package br.com.app.smallsells.userprofile.repository;

import br.com.app.smallsells.userprofile.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
