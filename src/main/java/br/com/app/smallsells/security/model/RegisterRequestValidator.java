package br.com.app.smallsells.security.model;

import br.com.app.smallsells.config.Validator;
import br.com.app.smallsells.exception.bundle.EmptyFieldException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.utils.GeneralMessages;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestValidator implements Validator<RegisterRequest> {

    @Override
    public void validateFields(RegisterRequest entity) throws GeneralException {
        if (entity.getEmail() == null) {
            throw new EmptyFieldException("Email" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPassword() == null) {
            throw new EmptyFieldException("Senha" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
