package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/address")
public class AddressController {
    private final AddressService addressService;
}
