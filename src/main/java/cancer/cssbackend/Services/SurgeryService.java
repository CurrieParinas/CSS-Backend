package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.Requests.AddSurgeryRequest;
import cancer.cssbackend.Entities.Surgery;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.HospitalRepository;
import cancer.cssbackend.Repositories.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;

    public Surgery addSurgery(AddSurgeryRequest addSurgeryRequest){
        Surgery surgery = addSurgeryRequest.mapToSurgery(patientService, doctorService, hospitalService, userService);
        surgeryRepository.save(surgery);
        return surgery;
    }

    public List<Hospital> fetchSurgeryHospitals(){
        List<Long> facilityIDs = surgeryRepository.fetchSurgeryHospitals();
        List<Hospital> hospitalList = new ArrayList<>();

        for(Long id : facilityIDs){
            Optional<Hospital> x = hospitalRepository.findById(id);
            x.ifPresent(hospitalList::add);
        }

        return hospitalList;
    }
}
