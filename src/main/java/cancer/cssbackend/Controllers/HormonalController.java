package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddHormonalRequest;
import cancer.cssbackend.Services.HormonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hormonal")
public class HormonalController {
    private final HormonalService hormonalService;

    @PostMapping("/add")
    public Hormonal addHormonal(@RequestBody AddHormonalRequest addHormonalRequest) {
        return hormonalService.addHormonal(addHormonalRequest);
    }
}
