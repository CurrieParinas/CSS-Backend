package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.RadDetails;
import cancer.cssbackend.Entities.Radiotherapy;
import cancer.cssbackend.Entities.Requests.AddRadiotherapyRequest;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.HospitalRepository;
import cancer.cssbackend.Repositories.RadiotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RadiotherapyService {
    private final RadiotherapyRepository radiotherapyRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final PatientService patientService;
    private final RadDetailsService radDetailsService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final UserService userService;

    public Radiotherapy addRadiotherapy(AddRadiotherapyRequest addRadiotherapyRequest){
        Radiotherapy radiotherapy = addRadiotherapyRequest.mapToRadiotherapy(patientService, radDetailsService, hospitalService, doctorService, userService);
        radiotherapyRepository.save(radiotherapy);
        return radiotherapy;
    }

    public List<Doctor> fetchAllRadiotherapyDoctors(){
        List<Long> doctorIDs = radiotherapyRepository.fetchAllRadiotherapyDoctors();
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Doctor> fetchRadiotherapyDoctorsByFacility(Long facilityID){
        List<Long> doctorIDs = radiotherapyRepository.fetchRadiotherapyDoctorsByFacility(facilityID);
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Hospital> fetchRadiotherapyFacilities(){
        List<Long> facilityIDs = radiotherapyRepository.fetchRadiotherapyFacilities();
        List<Hospital> hospitalList = new ArrayList<>();

        for(Long id : facilityIDs){
            Optional<Hospital> x = hospitalRepository.findById(id);
            x.ifPresent(hospitalList::add);
        }

        return hospitalList;
    }
}
