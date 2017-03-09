
package za.co.reverside.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.demo.model.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String>{
    
}
