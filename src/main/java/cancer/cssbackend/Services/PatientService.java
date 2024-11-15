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

    public Patient addPatient(AddPatientRequest addPatientRequest) throws MessagingException, IOException {
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

    public Map<String, Object> getADOCRH(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            Patient patient = optionalPatient.get();
            Disease disease = new Disease();
            if (diseaseRepository.findByPatient(patient) != null) {
                disease = diseaseRepository.findByPatient(patient);
            }
            Surgery surgery = new Surgery();
            if (!surgeryRepository.findByPatient(patient).isEmpty()) {
                surgery = surgeryRepository.findByPatient(patient).get(0);
            }
            List<Chemotherapy> chemotherapyList = chemotherapyRepository.findByPatient(patient);
            List<Radiotherapy> radiotherapyList = radiotherapyRepository.findByPatient(patient);
            List<Hormonal> hormonalList = hormonalRepository.findByPatient(patient);

            response.put("AGE", Period.between(patient.getUser().getUserBirthdate().toLocalDate(), LocalDate.now()).getYears());

            Map<String, Object> diagnosisMap = new HashMap<>();
            diagnosisMap.put("DATE", disease.getDiseaseDiagnosisDate());
            diagnosisMap.put("STAGE", disease.getDiseaseStage());
            diagnosisMap.put("LATERALITY", disease.getDiseaseLaterality());
            response.put("DIAGNOSIS", diagnosisMap);

            Map<String, Object> operationMap = new HashMap<>();
            operationMap.put("SURGERY", surgery.getSurgeryOperation());
            operationMap.put("DATE", surgery.getSurgeryDate());
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

            return response;
        }
        return null;
    }
}
