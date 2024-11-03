package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Consult;
import cancer.cssbackend.Entities.Requests.AddConsultRequest;
import cancer.cssbackend.Services.ConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/consult")
public class ConsultController {
    private final ConsultService consultService;

    @PostMapping("/add")
    public Consult addConsult(@RequestBody AddConsultRequest addConsultRequest) {
        return consultService.addConsult(addConsultRequest);
    }
}
