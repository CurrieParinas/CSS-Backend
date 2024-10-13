package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Repositories.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public Hospital findHospital(Long hospitalID){
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalID);
        return hospital.orElseThrow(() -> new RuntimeException("Hospital not found with ID " + hospitalID));
    }

    public List<Hospital> fetchAllHospitals(){
        return hospitalRepository.findAll();
    }
}
