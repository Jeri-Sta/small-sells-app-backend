package br.com.app.smallsells.profile.service;

import br.com.app.smallsells.profile.ProfileDTO;
import br.com.app.smallsells.profile.ProfileEntity;
import br.com.app.smallsells.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public List<ProfileDTO> listAll() {
        List<ProfileEntity> profiles = repository.findAll();
        return profiles.stream().map(ProfileDTO::new).toList();
    }

    public void create(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        repository.save(profileEntity);
    }

    public ProfileDTO update(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(repository.save(profileEntity));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> repository.delete(entity));
    }

    public ProfileDTO findById(Long id) {
        return new ProfileDTO(repository.findById(id).orElse(null));
    }
}
