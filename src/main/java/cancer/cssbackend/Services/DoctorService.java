package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final AccessRepository accessRepository;
    private final UserRepository userRepository;

    private final HospitalService hospitalService;
    private final DepartmentService departmentService;
    private final SpecialtyService specialtyService;

    public Doctor findDoctor(Long doctorID){
        Optional<Doctor> doctor = doctorRepository.findById(doctorID);
        return doctor.orElseThrow(() -> new RuntimeException("Doctor not found with ID " + doctorID));
    }

    public Doctor addDoctor(AddDoctorRequest addDoctorRequest, MultipartFile doctorESignature) throws IOException {
        Doctor doctor = addDoctorRequest.mapToDoctor(hospitalService, departmentService, specialtyService);
        doctor.setDoctorESignature(doctorESignature.getBytes());
        Address address = doctor.getUser().getUserAddress();
        addressRepository.save(address);

        User user = doctor.getUser();

        Optional<Role> optionalRole = roleRepository.findById(2L);
        optionalRole.ifPresent(user::setUserRole);

        Optional<Access> optionalAccess = accessRepository.findById(1L);
        optionalAccess.ifPresent(user::setUserAccess);

        user.setUserEncoder(user);
        userRepository.save(user);

        doctorRepository.save(doctor);

        return doctor;
    }

    public List<Doctor> fetchAllDoctors(){
        return doctorRepository.findAll();
    }

    public List<Doctor> findByHospital(Long hospitalID){
        Hospital hospital = hospitalService.findHospital(hospitalID);

        return doctorRepository.findByHospital(hospital);
    }

    public List<Doctor> findAllSurgeons (){
        List<Long> surgeonIDs = doctorRepository.findAllSurgeons();
        List<Doctor> surgeonList = new ArrayList<>();
        for(Long id : surgeonIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(surgeonList::add);
        }

        return surgeonList;
    }

    public List<Doctor> findSurgeonByHospital(Long hospitalID){
        List<Doctor> surgeonsByHospital = new ArrayList<>();
        List<Long> surgeonIDs = doctorRepository.findSurgeonsByHosp(hospitalID);

        for(Long id : surgeonIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(surgeonsByHospital::add);
        }

        return surgeonsByHospital;
    }

    public List<Doctor> fetchDoctorsOfAPatient(Long patientID){
        List<Doctor> doctorsByPatient = new ArrayList<>();
        List<Long> doctorIDs = doctorRepository.fetchDoctorsOfAPatient(patientID);

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorsByPatient::add);
        }

        return doctorsByPatient;
    }
}
