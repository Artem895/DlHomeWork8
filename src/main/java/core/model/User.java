package core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class User {
    @Id
    private long id;

    private String name;

    private String password;

    private Role role;
}
