package fr.iut.nd.pkdxapi.models;

import java.util.Optional;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("UserDTO")
public class UserDTO {
    
    private String login;
    private String password;
    private boolean isAdmin;

    public UserDTO(String login, String password, Optional<Boolean> isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin.orElse(false);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
