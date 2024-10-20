package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Patient addPatient(AddPatientRequest addPatientRequest) {
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
}
