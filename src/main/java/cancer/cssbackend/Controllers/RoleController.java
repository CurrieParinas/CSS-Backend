package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/role")
public class RoleController {
    private final RoleService roleService;
}
