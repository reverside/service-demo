package za.co.reverside.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
   
}