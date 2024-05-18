package br.com.app.smallsells.exception;

import br.com.app.smallsells.exception.bundle.AuthenticationAppException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(onMethod_ = @Autowired)
public class ApplicationExcepitonHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({GeneralException.class, AuthenticationAppException.class})
    public ResponseEntity<DefaultError> handleGeneralException(Exception e) {
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
