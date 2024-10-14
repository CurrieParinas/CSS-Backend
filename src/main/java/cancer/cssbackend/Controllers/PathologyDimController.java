package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.PathologyDimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/pathologydim")
public class PathologyDimController {
    private final PathologyDimService pathologyDimService;
}
