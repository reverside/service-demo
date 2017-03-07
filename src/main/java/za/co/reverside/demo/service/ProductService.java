package za.co.reverside.demo.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.reverside.demo.model.Product;
import za.co.reverside.demo.repository.ProductRepository;

@RestController
public class ProductService{
    
   @Autowired
   private ProductRepository productRepository;
    
    @RequestMapping(path = "api/products", method=RequestMethod.POST, consumes = "application/json")
    public void createProduct(@RequestBody Product product){
        this.productRepository.insert(product);
    }
    
    @RequestMapping(path = "api/products/{productId}", method=RequestMethod.PUT, consumes = "application/json")
    public void updateProduct(@PathVariable String productId, @RequestBody Product request){
         Product product = this.productRepository.findOne(productId);
         if(product != null){
             product.setName(request.getName());
             product.setDecription(request.getDecription());
             productRepository.save(product);
         }else {
             throw new RuntimeException("No such product found");
         }
    }
    
    @RequestMapping(path = "api/products", method=RequestMethod.GET, produces = "application/json")
    public List<Product> findProducts(){
        return this.productRepository.findAll();
    }
    
    @RequestMapping(path = "api/products/{productId}", method = RequestMethod.GET, produces = "application/json")
    public Product findProduct(@PathVariable("productId") String productId){
        return this.productRepository.findOne(productId);
    }
    
    @RequestMapping(path = "api/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("productId") String productId){
       Product product = this.productRepository.findOne(productId);
         if(product != null){
             productRepository.delete(productId);
         }else {
             throw new RuntimeException("No such product found");
         }
    }
   
}