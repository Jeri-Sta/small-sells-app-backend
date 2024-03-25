package br.com.app.smallsells.user.service;

import br.com.app.smallsells.user.UserDTO;
import br.com.app.smallsells.user.UserEntity;
import br.com.app.smallsells.user.UserSituationType;
import br.com.app.smallsells.user.repository.UserRepository;
import br.com.app.smallsells.userprofile.userverifier.UserVerifierEntity;
import br.com.app.smallsells.userprofile.userverifier.service.UserVerifierService;
import br.com.app.smallsells.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserVerifierService userVerifierService;

    public List<UserDTO> listAll(){
        List<UserEntity> usuarios = repository.findAll();
        return usuarios.stream().map(UserDTO::new).toList();
    }

    public void create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        repository.save(userEntity);
    }

    public void createNewUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setUserSituationType(UserSituationType.PENDING);
        userEntity.setId(null);
        repository.save(userEntity);

        UserVerifierEntity userVerifierEntity = new UserVerifierEntity();
        userVerifierEntity.setUser(userEntity);
        userVerifierEntity.setUuid(UUID.randomUUID());
        userVerifierEntity.setExpirationDate(Instant.now().plusMillis(900000));
        userVerifierService.save(userVerifierEntity);

        emailService.sendTextEmail(userEntity.getEmail(),
                "Novo usuário cadastro",
                "Você está recebendo um email de cadastro. O código para validação é " + userVerifierEntity.getUuid());
    }

    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return new UserDTO(repository.save(userEntity));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> repository.delete(entity));
    }

    public UserDTO findById(Long id) {
        return new UserDTO(repository.findById(id).orElse(null));
    }
}
