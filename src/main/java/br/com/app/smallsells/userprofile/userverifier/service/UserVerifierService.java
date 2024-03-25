package br.com.app.smallsells.userprofile.userverifier.service;

import br.com.app.smallsells.userprofile.userverifier.UserVerifierEntity;
import br.com.app.smallsells.userprofile.userverifier.repository.UserVerifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVerifierService {

    @Autowired
    private UserVerifierRepository repository;

    public void save(UserVerifierEntity userVerifierEntity) {
        repository.save(userVerifierEntity);
    }
}
