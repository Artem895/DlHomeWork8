package core.controler;
import core.model.User;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Не должно быть пустым");
        if (user.getName().length() < 6 || user.getName().length() > 32) {
            errors.rejectValue("name", "Слишком коротко или длинно","Слишком коротко или длинно");
        }
        if (userService.finduserbyname(user.getName()) != null) {
            errors.rejectValue("name", "Такой уже есть","Такой уже есть");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Не должно быть пустым ");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Короткий или длинный пароль","Короткий или длинный пароль");
        }

    }
}