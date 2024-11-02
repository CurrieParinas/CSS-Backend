package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Requests.AddHormonalRequest;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.HormonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HormonalService {
    private final HormonalRepository hormonalRepository;
    private final DoctorRepository doctorRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;

    public Hormonal addHormonal(AddHormonalRequest addHormonalRequest){
        Hormonal hormonal = addHormonalRequest.mapToHormonal(patientService, doctorService, userService);
        hormonalRepository.save(hormonal);
        return hormonal;
    }

    public List<Doctor> fetchAllHormonalDoctors(){
        List<Long> doctorIDs = doctorRepository.findAllSurgeons();
        List<Doctor> doctorList = new ArrayList<>();
        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }
}
