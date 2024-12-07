package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Projections.WorkupProjection;
import cancer.cssbackend.Entities.Workup;
import cancer.cssbackend.Services.WorkupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/workup")
public class WorkupController {
    private final WorkupService workupService;

    @GetMapping("/fetchbycancertype")
    public List<WorkupProjection> getWorkupProjection(@RequestParam(value="cancerType") Long cancerType){
        return workupService.getWorkupProjections(cancerType);
    }

    @GetMapping("/all")
    public List<Workup> getAll(){
        return workupService.getAllWorkup();
    }
}
