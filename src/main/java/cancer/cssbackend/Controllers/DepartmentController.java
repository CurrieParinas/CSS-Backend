package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Department;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        return departmentService.fetchAllDepartments();
    }
}
