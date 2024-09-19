package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.BodySiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/bodysite")
public class BodySiteController {
    private final BodySiteService bodySiteService;
}
