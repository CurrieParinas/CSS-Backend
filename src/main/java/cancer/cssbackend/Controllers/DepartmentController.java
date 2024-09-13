package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Department;
import cancer.cssbackend.Services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/address")
public class DepartmentController {
    private final DepartmentService departmentService;
}
