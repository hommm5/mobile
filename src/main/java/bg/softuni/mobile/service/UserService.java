package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.UserLoginDTO;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userLoginDTO.getUsername());

        if(optionalUser.isEmpty()){
            LOGGER.info("User with name {} not found.", userLoginDTO.getUsername());
            return false;
        }
        boolean success = optionalUser.get().getPassword().equals(userLoginDTO.getPassword());

        if (success){
            login(optionalUser.get());
        }else {
            logout();
        }

        return success;
    }
    private void login(UserEntity userEntity){
        currentUser.setLoggedIn(true).
                setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }
    public void logout(){
        currentUser.clear();
    }
}
