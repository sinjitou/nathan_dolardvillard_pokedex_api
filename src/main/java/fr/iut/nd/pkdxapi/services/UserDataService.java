package fr.iut.nd.pkdxapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.iut.nd.pkdxapi.errors.UserAlreadyExistException;
import fr.iut.nd.pkdxapi.models.UserDTO;
import fr.iut.nd.pkdxapi.models.UserData;
import fr.iut.nd.pkdxapi.repositories.UserRepository;

@Service
public class UserDataService {
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDataService(UserRepository repository) {
        this.repository = repository;
    }

    private boolean usernameExist(String username) {
         UserData userIsExist = repository.findByUsername(username);
         boolean exist = userIsExist != null;
         return exist;
    }


     public void register(UserDTO userDTO) {
          String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        UserData userData = new UserData(
            userDTO.getLogin(), 
            encryptedPassword, 
            userDTO.isAdmin()
     );

     if(usernameExist(userData.getLogin())) {
        throw new UserAlreadyExistException("User already exists");
     }

     repository.insert(userData);
            
     }


     
}
