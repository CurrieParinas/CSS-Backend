package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Requests.AddHormonalRequest;
import cancer.cssbackend.Repositories.HormonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class HormonalService {
    private final HormonalRepository hormonalRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;

    public Hormonal addHormonal(AddHormonalRequest addHormonalRequest){
        Hormonal hormonal = addHormonalRequest.mapToHormonal(patientService, doctorService, userService);
        hormonalRepository.save(hormonal);
        return hormonal;
    }
}
