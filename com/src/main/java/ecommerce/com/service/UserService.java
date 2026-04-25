package ecommerce.com.service;

import ecommerce.com.model.User;
import ecommerce.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    //               create User
    public ResponseEntity<?> createUser(User user)
    {
        if(user!=null ) {
            if( user.getName()!=null && !user.getName().equals("") && user.getPassword()!=null && !user.getPassword().equals("")) {

                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                User savedUser = userRepository.save(user);

                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(HttpStatus.valueOf("invalid data "));
            }
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    //    get All user
    public  ResponseEntity<?> getAllUser(){
      List<User> user = userRepository.findAll();

      return  new ResponseEntity<>(user,HttpStatus.OK);

    }




}
