package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.RadDetails;
import cancer.cssbackend.Entities.Radiotherapy;
import cancer.cssbackend.Entities.Requests.AddRadiotherapyRequest;
import cancer.cssbackend.Repositories.RadiotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RadiotherapyService {
    private final RadiotherapyRepository radiotherapyRepository;
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
}
