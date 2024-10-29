package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.Requests.AddSurgeryRequest;
import cancer.cssbackend.Entities.Surgery;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;

    public Surgery addSurgery(AddSurgeryRequest addSurgeryRequest){
        Surgery surgery = addSurgeryRequest.mapToSurgery(patientService, doctorService, hospitalService, userService);
        surgeryRepository.save(surgery);
        return surgery;
    }
}
