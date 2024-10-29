package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Immunotherapy;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddImmunotherapyRequest;
import cancer.cssbackend.Repositories.ImmunotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class ImmunotherapyService {
    private final ImmunotherapyRepository immunotherapyRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;

    public Immunotherapy addImmunotherapy(AddImmunotherapyRequest addImmunotherapyRequest){
        Immunotherapy immunotherapy = addImmunotherapyRequest.mapToImmunotherapy(patientService, doctorService, userService, hospitalService);
        immunotherapyRepository.save(immunotherapy);
        return immunotherapy;
    }
}
