package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Chemoprotocol;
import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Repositories.ChemotherapyRepository;
import cancer.cssbackend.Repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemotherapyService {
    private final ChemotherapyRepository chemotherapyRepository;
    private final PatientService patientService;
    private final ChemoprotocolService chemoprotocolService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final DoctorRepository doctorRepository;

    public Chemotherapy addChemotherapy (AddChemotherapyRequest addChemotherapyRequest){
        Chemotherapy chemotherapy = addChemotherapyRequest.mapToChemotherapy(patientService, chemoprotocolService, hospitalService, doctorService, userService);
        chemotherapyRepository.save(chemotherapy);
        return chemotherapy;
    }

    public List<Doctor> fetchAllDoctors(){
        List<Long> doctorIDs = chemotherapyRepository.fetchAllDoctors();
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Doctor> fetchDoctorsByFacility(Long facilityID){
        List<Long> doctorIDs = chemotherapyRepository.fetchDoctorsByFacility(facilityID);
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }
}
