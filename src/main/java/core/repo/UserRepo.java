package core.repo;

import core.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
    User findUserById(Long id);

    User findUserByName(String name);
}
