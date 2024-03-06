package fr.iut.nd.pkdxapi.services;


import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.iut.nd.pkdxapi.models.UserData;
import fr.iut.nd.pkdxapi.repositories.UserRepository;


public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    private List<GrantedAuthority> userAuthorities;
    private List<GrantedAuthority> adminAuthorities;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userAuthorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        adminAuthorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> data = userRepository.findById(username);
        if(!data.isPresent()) throw new UsernameNotFoundException(username);
        UserData user = data.get();
        List<GrantedAuthority> authorities = user.isAdmin()?adminAuthorities:userAuthorities;
        return new User(user.getLogin(), user.getPassword(),authorities);
    }

    
    
}
