package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.MetastaticSiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mets")
public class MetastaticSiteController {
    private final MetastaticSiteService metastaticSiteService;
}
