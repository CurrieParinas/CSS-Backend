package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Department;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department findDepartment(Long departmentID){
        Optional<Department> department = departmentRepository.findById(departmentID);
        return department.orElseThrow(() -> new RuntimeException("Department not found with ID " + departmentID));
    }

    public List<Department> fetchAllDepartments(){
        return departmentRepository.findAll();
    }
}
