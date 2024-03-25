package br.com.app.smallsells.userprofile.service;

import br.com.app.smallsells.userprofile.UserProfileDTO;
import br.com.app.smallsells.userprofile.UserProfileEntity;
import br.com.app.smallsells.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public List<UserProfileDTO> listAll() {
        List<UserProfileEntity> userProfiles = repository.findAll();
        return userProfiles.stream().map(UserProfileDTO::new).toList();
    }

    public void create(UserProfileDTO userProfileDTO) {
        UserProfileEntity userProfileEntity = new UserProfileEntity(userProfileDTO);
        repository.save(userProfileEntity);
    }

    public UserProfileDTO update(UserProfileDTO userProfileDTO) {
        UserProfileEntity userProfileEntity = new UserProfileEntity(userProfileDTO);
        return new UserProfileDTO(repository.save(userProfileEntity));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> repository.delete(entity));
    }

    public UserProfileDTO findById(Long id) {
        return new UserProfileDTO(repository.findById(id).orElse(null));
    }
}
