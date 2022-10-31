package core.service;

import core.exeption.EntityNotFoundException;
import core.model.User;
import core.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User finduserbyname(String name)  {
        return userRepo.findUserByName(name);
    }
    public User save(User user){
        return userRepo.save(user);
    }
}
