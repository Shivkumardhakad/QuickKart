package ecommerce.com.service;

import ecommerce.com.model.User;
import ecommerce.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User loadUser= userRepository.findUserById(username).orElse(null);

        if(loadUser!=null)
        {var authorities = loadUser.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role)) // Har string ko Authority mein badla
                .collect(Collectors.toList());
              return  new org.springframework.security.core.userdetails.User(loadUser.getName(),loadUser.getPassword(),authorities);
        }
       throw new UsernameNotFoundException("user nai mila"+username);

    }
}
