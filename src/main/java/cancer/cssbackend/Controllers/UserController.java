package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping(path="/{userId}")
    public User getUser(@PathVariable Long userId){return userService.getUser(userId);}
}
