package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping(path="/{userId}")
    public User getUser(@PathVariable Long userId){return userService.getUser(userId);}

    @GetMapping(path="/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(path="/editstatus")
    public String editStatus(@RequestParam(value="userID") Long userID, @RequestParam(value="userStatus") String userStatus){
        return userService.editStatus(userID, userStatus);
    }
}
