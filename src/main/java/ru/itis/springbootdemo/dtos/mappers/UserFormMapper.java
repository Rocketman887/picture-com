import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.models.User;

@Mapper(componentModel = "spring")
public interface UserFormMapper {

    @Mappings({
            @Mapping(target = "email", source = "form.email"),
            @Mapping(target = "hashPassword", source = "form.password"),
            @Mapping(target = "name", source = "form.name")
    })
    User FormToUser(UserForm form);

    @InheritInverseConfiguration
    UserForm userToForm(User user);
}