package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.LabsDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/download")
public class LabsDownloadController {
    private final LabsDownloadService labsDownloadService;
}
