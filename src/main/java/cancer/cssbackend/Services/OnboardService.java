package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Onboard;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.OnboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnboardService {
    private final OnboardRepository onboardRepository;
    private final DoctorRepository doctorRepository;

    public List<Onboard> getPatientsByDoctor(Long doctorId) {
        return onboardRepository.findAllByDoctor(doctorRepository.findById(doctorId));
    }
}
