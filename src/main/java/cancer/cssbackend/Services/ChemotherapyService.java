package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Chemoprotocol;
import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Repositories.ChemotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemotherapyService {
    private final ChemotherapyRepository chemotherapyRepository;
    private final PatientService patientService;
    private final ChemoprotocolService chemoprotocolService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final UserService userService;

    public Chemotherapy addChemotherapy (AddChemotherapyRequest addChemotherapyRequest){
        Chemotherapy chemotherapy = addChemotherapyRequest.mapToChemotherapy(patientService, chemoprotocolService, hospitalService, doctorService, userService);
        chemotherapyRepository.save(chemotherapy);
        return chemotherapy;
    }
}
