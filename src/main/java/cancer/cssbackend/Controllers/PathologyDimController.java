package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Department;
import cancer.cssbackend.Entities.PathologyDim;
import cancer.cssbackend.Services.PathologyDimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/pathologydim")
public class PathologyDimController {
    private final PathologyDimService pathologyDimService;

    @GetMapping("/all")
    public List<PathologyDim> getAllPathologyDim(){
        return pathologyDimService.fetchAllPathologyDim();
    }
}
