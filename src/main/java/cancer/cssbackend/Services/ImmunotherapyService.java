package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Immunotherapy;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddImmunotherapyRequest;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.ImmunotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImmunotherapyService {
    private final ImmunotherapyRepository immunotherapyRepository;
    private final DoctorRepository doctorRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;

    public Immunotherapy addImmunotherapy(AddImmunotherapyRequest addImmunotherapyRequest){
        Immunotherapy immunotherapy = addImmunotherapyRequest.mapToImmunotherapy(patientService, doctorService, userService, hospitalService);
        immunotherapyRepository.save(immunotherapy);
        return immunotherapy;
    }

    public List<Doctor> fetchAllDoctors(){
        List<Long> doctorIDs = immunotherapyRepository.fetchAllDoctors();
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Doctor> fetchDoctorsByFacility(Long facilityID){
        List<Long> doctorIDs = immunotherapyRepository.fetchImmunotherapyDoctorsByFacility(facilityID);
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }
}
