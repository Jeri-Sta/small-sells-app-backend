package br.com.app.smallsells.exception;

import br.com.app.smallsells.exception.bundle.AuthenticationAppException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExcepitonHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity handleException(Exception e) {
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationAppException.class)
    public ResponseEntity handleEmailNotFoundException(Exception e) {
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
