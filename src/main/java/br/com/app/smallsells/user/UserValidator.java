package br.com.app.smallsells.user;

import br.com.app.smallsells.config.Validator;
import br.com.app.smallsells.exception.bundle.EmptyFieldException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.user.model.User;
import br.com.app.smallsells.utils.GeneralMessages;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User> {

    @Override
    public void validateFields(User entity) throws GeneralException {
        if (entity.getEmail() == null) {
            throw new EmptyFieldException("Email" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPassword() == null) {
            throw new EmptyFieldException("Senha" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getRole() == null) {
            throw new EmptyFieldException("Papel" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
