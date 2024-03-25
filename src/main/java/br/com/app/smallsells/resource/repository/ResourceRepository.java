package br.com.app.smallsells.resource.repository;

import br.com.app.smallsells.resource.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
