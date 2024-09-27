package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.RadDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/raddetails")
public class RadDetailsController {
    private final RadDetailsService radDetailsService;
}
