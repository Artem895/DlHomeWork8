package core.rest;

import core.model.User;
import core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class Controller {

    private final UserRepo userRepo;

    @Autowired
    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/w")
    @PreAuthorize("hasAuthority('write')")
    public  String welcome(){
        return "U are welcome";
    }


    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('read')")
    public User getUserbyId(@PathVariable long id){
        return userRepo.findUserById(id);
    }
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('write')")
    public User insert(@RequestBody String user){
        return null;
    }
}
