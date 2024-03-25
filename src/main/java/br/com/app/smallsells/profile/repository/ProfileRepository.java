package br.com.app.smallsells.profile.repository;

import br.com.app.smallsells.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
