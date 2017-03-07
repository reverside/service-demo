package za.co.reverside.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.demo.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
