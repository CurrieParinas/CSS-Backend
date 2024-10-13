package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Specialty;
import cancer.cssbackend.Repositories.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public Specialty findSpecialty(Long specialtyID){
        Optional<Specialty> specialty = specialtyRepository.findById(specialtyID);
        return specialty.orElseThrow(() -> new RuntimeException("Specialty not found with ID " + specialtyID));
    }

    public List<Specialty> fetchAllSpecialties(){
        return specialtyRepository.findAll();
    }
}
