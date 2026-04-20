package ecommerce.com.service;

import ecommerce.com.model.User;
import ecommerce.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> createUser(User user)
    {
        if(user!=null ) {
            if( user.getName()!=null && !user.getName().equals("") && user.getPassword()!=null && !user.getPassword().equals("")) {
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

}
