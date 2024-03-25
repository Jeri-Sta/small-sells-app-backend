package br.com.app.smallsells.userprofile.userverifier.repository;

import br.com.app.smallsells.userprofile.userverifier.UserVerifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerifierRepository extends JpaRepository<UserVerifierEntity, Long> {
}
