package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.BodySite;
import cancer.cssbackend.Entities.PathologyDim;
import cancer.cssbackend.Services.BodySiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/bodysite")
public class BodySiteController {
    private final BodySiteService bodySiteService;

    @GetMapping("/all")
    public List<BodySite> getAllBodySite(){
        return bodySiteService.fetchAllBodySite();
    }
}
