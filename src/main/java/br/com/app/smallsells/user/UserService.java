package br.com.app.smallsells.user;

import br.com.app.smallsells.exception.bundle.EntityNotFoundException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.user.model.User;
import br.com.app.smallsells.user.model.UserDto;
import br.com.app.smallsells.utils.GeneralMessages;
import jakarta.validation.ConstraintViolationException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Setter(onMethod_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;
    UserValidator userValidator;

    public Page<UserDto> listAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, UserDto.class));
    }

    public UserDto listById(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return modelMapper.map(optional.orElse(new User()), UserDto.class);
    }

    public UserDto createUser(UserDto dto) throws GeneralException {
        User user = modelMapper.map(dto, User.class);
        try {
            userValidator.validateFields(user);
            userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new GeneralException(e.getConstraintViolations().toString());
        }

        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(UserDto dto) throws GeneralException {
        User user = modelMapper.map(dto, User.class);
        if(userRepository.findById(user.getId()).isEmpty()){
            throw new EntityNotFoundException("Usuário" + GeneralMessages.ENTITY_NOT_FOUND);
        }
        try {
            userValidator.validateFields(user);
            userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new GeneralException(e.getConstraintViolations().toString());
        }

        return modelMapper.map(user, UserDto.class);
    }
}
