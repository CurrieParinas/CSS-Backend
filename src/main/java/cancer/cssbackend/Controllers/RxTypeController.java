package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddRxTypeRequest;
import cancer.cssbackend.Services.RxTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/rxtype")
public class RxTypeController {
    private final RxTypeService rxTypeService;
    @PostMapping("/add")
    public RXType addRXType(@RequestBody AddRxTypeRequest addRxTypeRequest) {
        return rxTypeService.addRXType(addRxTypeRequest);
    }
}
