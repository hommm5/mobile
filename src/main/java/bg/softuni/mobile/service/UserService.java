package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.UserLoginDTO;
import bg.softuni.mobile.model.dto.UserRegisterDTO;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.model.mapper.UserMapper;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDTO userLoginDTO) {

        Optional<UserEntity> optionalUser = userRepository.findByEmail(userLoginDTO.getUsername());

        if (optionalUser.isEmpty()) {
            LOGGER.info("User with name {} not found.", userLoginDTO.getUsername());
            return false;
        }
        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = optionalUser.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(optionalUser.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true).
                setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = userMapper.userDtoUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }
}
