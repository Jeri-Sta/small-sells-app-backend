package br.com.app.smallsells.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {

    private String code;
    private String message;
}
