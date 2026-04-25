package ecommerce.com.repository;

import ecommerce.com.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

     Optional<User> findUserById(String name);


}
