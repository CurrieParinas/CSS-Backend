package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Repositories.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AccessRepository accessRepository;
    private final AddressRepository addressRepository;
    private final OnboardRepository onboardRepository;
    private final DoctorRepository doctorRepository;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final EmailService emailService;
    private final DiseaseRepository diseaseRepository;
    private final SurgeryRepository surgeryRepository;
    private final ChemotherapyRepository chemotherapyRepository;
    private final RadiotherapyRepository radiotherapyRepository;
    private final HormonalRepository hormonalRepository;
    private final ConsultRepository consultRepository;
    private final LabSubmittedRepository labSubmittedRepository;

    public Patient addPatient(AddPatientRequest addPatientRequest) throws MessagingException {
        Patient patient = addPatientRequest.mapToPatient();
        Address address = patient.getUser().getUserAddress();
        addressRepository.save(address);
        User user = patient.getUser();
        Optional<Role> optionalRole = roleRepository.findById(3L);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            user.setUserRole(role);
        }
        Optional<Access> optionalAccess = accessRepository.findById(1L);
        if (optionalAccess.isPresent()) {
            Access access = optionalAccess.get();
            user.setUserAccess(access);
        }
        Optional<User> optionalEncoder = userRepository.findById(addPatientRequest.getUserEncoder());
        if (optionalEncoder.isPresent()) {
            User encoder = optionalEncoder.get();
            user.setUserEncoder(encoder);
        }
        String temporaryPassword = TemporaryPasswordService.generateTemporaryPassword();
        user.setUserPassword(temporaryPassword);

        userRepository.save(user);
        patient.setUser(user);
        patientRepository.save(patient);
        if (patient.getUser().getUserEncoder().getUserRole().getRoleId() == 2) {
            Onboard onboard = new Onboard();
            Doctor doctor = doctorRepository.findByUser(patient.getUser().getUserEncoder());
            onboard.setPatient(patient);
            onboard.setDoctor(doctor);
            onboardRepository.save(onboard);
        }

        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.setUser(user);
        forgotPassword.setToken(token);
        forgotPassword.setExpiry(Timestamp.valueOf(expiryDate));
        emailService.sendTempPassEmail(addPatientRequest.getUserEmail(), "Welcome to Cancer Surveillance System", user.getUserId(), token, temporaryPassword);
        forgotPasswordRepository.save(forgotPassword);

        return patient;
    }

    public Patient updatePatient(AddPatientRequest addPatientRequest, Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient = addPatientRequest.mapToPatient(patient, patient.getUser().getUserAddress(), patient.getUser());
            Address address = patient.getUser().getUserAddress();
            addressRepository.save(address);
            User user = patient.getUser();

            Optional<User> optionalEncoder = userRepository.findById(addPatientRequest.getUserEncoder());
            if (optionalEncoder.isPresent()) {
                User encoder = optionalEncoder.get();
                user.setUserEncoder(encoder);
            }

            userRepository.save(user);
            patient.setUser(user);
            patientRepository.save(patient);
            return patient;
        }
        return null;
    }
  
    public Patient findPatient(Long patientID){
        Optional<Patient> patient = patientRepository.findById(patientID);
        return patient.orElseThrow(() -> new RuntimeException("Patient not found with ID " + patientID));
    }

    public String deletePatient(Long patientID){
        Optional<Patient> patientToDelete = patientRepository.findById(patientID);

        if(patientToDelete.isPresent()){
            //delete muna mga onboard
            List<Onboard> onboardList = onboardRepository.findByPatient(patientToDelete);
            onboardRepository.deleteAll(onboardList);

            //find user entry ng patient
            User userToDelete = patientToDelete.get().getUser();

            //then delete patient
            patientRepository.delete(patientToDelete.get());

            //then call delete user
            userRepository.delete(userToDelete);

            return "Successfully deleted the patient's account";
        }
        return "Deletion unsuccessful or no patient with that ID exists";
    }

    public Map<String, Object> getConsultInfo(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            Patient patient = optionalPatient.get();
            Disease disease = diseaseRepository.findByPatient(patient);
            List<Surgery> surgeryList = surgeryRepository.findByPatient(patient);
            List<Chemotherapy> chemotherapyList = chemotherapyRepository.findByPatient(patient);
            List<Radiotherapy> radiotherapyList = radiotherapyRepository.findByPatient(patient);
            List<Hormonal> hormonalList = hormonalRepository.findByPatient(patient);
            List<Consult> consultList = consultRepository.findByPatient(patient);
            List<LabSubmitted> labSubmittedList = labSubmittedRepository.findByPatient(patient);

            Map<String, Object> nameMap = new HashMap<>();
            nameMap.put("LASTNAME", patient.getUser().getUserLastname());
            nameMap.put("FIRSTNAME", patient.getUser().getUserFirstname());
            nameMap.put("MIDDLENAME", patient.getUser().getUserMiddlename());
            response.put("NAME", nameMap);

            response.put("AGE", Period.between(patient.getUser().getUserBirthdate().toLocalDate(), LocalDate.now()).getYears());

            Map<String, Object> diagnosisMap = new HashMap<>();
            diagnosisMap.put("DATE", disease != null ? disease.getDiseaseDiagnosisDate() : null);
            diagnosisMap.put("STAGE", disease != null ? disease.getDiseaseStage() : null);
            diagnosisMap.put("LATERALITY", disease != null ? disease.getDiseaseLaterality() : null);
            response.put("DIAGNOSIS", diagnosisMap);

            Map<String, Object> operationMap = new HashMap<>();
            if (!surgeryList.isEmpty()) {
                Surgery surgery = surgeryList.get(0);
                operationMap.put("SURGERY", surgery.getSurgeryOperation());
                operationMap.put("DATE", surgery.getSurgeryDate());
            } else {
                operationMap.put("SURGERY", null);
                operationMap.put("DATE", null);
            }
            response.put("OPERATION", operationMap);

            Map<String, Object> chemotherapyMap = new HashMap<>();
            if (!chemotherapyList.isEmpty()) {
                boolean notCompletedFound = false;
                for (Chemotherapy chemo : chemotherapyList) {
                    if ("N".equals(chemo.getChemoIsCompleted())) {
                        chemotherapyMap.put("YN", "Yes");
                        chemotherapyMap.put("COMPLETION", "Not Completed");
                        notCompletedFound = true;
                        break;
                    }
                }

                if (!notCompletedFound) {
                    chemotherapyMap.put("YN", "Yes");
                    chemotherapyMap.put("COMPLETION", "Completed");
                }
            } else {
                chemotherapyMap.put("YN", "No");
                chemotherapyMap.put("COMPLETION", null);
            }
            response.put("CHEMOTHERAPY", chemotherapyMap);

            Map<String, Object> radiotherapyMap = new HashMap<>();
            if (!radiotherapyList.isEmpty()) {
                boolean notCompletedFound = false;
                for (Radiotherapy radio : radiotherapyList) {
                    if ("N".equals(radio.getRadRxIsCompleted())) {
                        radiotherapyMap.put("YN", "Yes");
                        radiotherapyMap.put("COMPLETION", "Not Completed");
                        notCompletedFound = true;
                        break;
                    }
                }

                if (!notCompletedFound) {
                    radiotherapyMap.put("YN", "Yes");
                    radiotherapyMap.put("COMPLETION", "Completed");
                }
            } else {
                radiotherapyMap.put("YN", "No");
                radiotherapyMap.put("COMPLETION", null);
            }
            response.put("RADIOTHERAPY", radiotherapyMap);

            Map<String, Object> hormonalTherapyMap = new HashMap<>();
            if (!hormonalList.isEmpty()) {
                boolean notCompletedFound = false;
                for (Hormonal hormonal : hormonalList) {
                    if ("Non-compliant".equals(hormonal.getHormonalStatus())) {
                        hormonalTherapyMap.put("YN", "Yes");
                        hormonalTherapyMap.put("COMPLIANCE", "Non-compliant");
                        notCompletedFound = true;
                        break;
                    }
                }

                if (!notCompletedFound) {
                    hormonalTherapyMap.put("YN", "Yes");
                    hormonalTherapyMap.put("COMPLIANCE", "Compliant");
                }
            } else {
                hormonalTherapyMap.put("YN", "No");
                hormonalTherapyMap.put("COMPLIANCE", null);
            }
            response.put("HORMONAL_THERAPY", hormonalTherapyMap);

            response.put("STATUS", patient.getUser().getUserStatus());

            //from timestamp ginawa ko na date -nathan
            Date latestDate = null;
            for (Consult consult : consultList) {
                Date consultDate = consult.getConsultDate();
                if (latestDate == null || consultDate.after(latestDate)) {
                    latestDate = consultDate;
                }
            }
            response.put("LATEST_CONSULT_DATE", latestDate);


            LabSubmitted latestLabSubmitted = null;
            for (LabSubmitted labSubmitted : labSubmittedList) {
                if (latestLabSubmitted == null || labSubmitted.getLabSubmissionDate().after(latestLabSubmitted.getLabSubmissionDate())) {
                    latestLabSubmitted = labSubmitted;
                }
            }
            response.put("LATEST_LAB_SUBMITTED", latestLabSubmitted != null ? latestLabSubmitted.getWorkupName().getWorkupName() : null);
            response.put("LATEST_LAB_DATE", latestLabSubmitted != null ? latestLabSubmitted.getLabSubmissionDate() : null);
            response.put("PATIENT_SISX_REPORT", null);
            response.put("PATIENT_REPORT_DATE", null);
            return response;
        }
        return null;
    }

    public Patient fetchLatestCreatedPatient(Long doctorID) {
        Patient patient = patientRepository.fetchLatestCreatedPatient(doctorID);
        if (patient != null) {
            return patient;
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

}
