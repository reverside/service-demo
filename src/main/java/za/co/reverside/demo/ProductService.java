package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductService{
    
    private Map<String, Product> products = new HashMap<String, Product>();
    
    @RequestMapping(path = "api/products", method=RequestMethod.POST, consumes = "application/json")
    public void createProduct(@RequestBody Product product){
        if(this.products.get(product.getId())== null){
            this.products.put(product.getId(), product);
        } else {
            throw new RuntimeException("Product with such already ID exists");
        } 
    }
    
    @RequestMapping(path = "api/products/{productId}", method=RequestMethod.PUT, consumes = "application/json")
    public void updateProduct(@PathVariable String productId, @RequestBody Product request){
         Product product = this.products.get(productId);
         if(product != null){
             product.setName(request.getName());
             product.setDecription(request.getDecription());
         }else {
             throw new RuntimeException("No such product found");
         }
    }
    
    @RequestMapping(path = "api/products", method=RequestMethod.GET, produces = "application/json")
    public Collection<Product> findProducts(){
        return this.products.values();
    }
    
    @RequestMapping(path = "api/products/{productId}", method = RequestMethod.GET, produces = "application/json")
    public Product findProduct(@PathVariable("productId") String productId){
        return this.products.get(productId);
    }
    
    @RequestMapping(path = "api/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("productId") String productId){
        this.products.remove(productId);
    }
    
    
}