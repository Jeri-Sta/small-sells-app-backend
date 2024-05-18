package br.com.app.smallsells.config;

import br.com.app.smallsells.exception.bundle.GeneralException;

public interface Validator<T> {

    void validateFields(T entity) throws GeneralException;
}
