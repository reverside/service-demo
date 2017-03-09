package za.co.reverside.demo.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import za.co.reverside.demo.repository.UserRepository;
import za.co.reverside.demo.model.User;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "api/users", method = RequestMethod.POST, consumes = "application/json")
    public void createUser(@RequestBody User user) {
        this.userRepository.insert(user);
    }

    @RequestMapping(path = "api/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> findUsers() {
        return this.userRepository.findAll();
    }

    @RequestMapping(path = "api/users/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateUser(@PathVariable String userId, @RequestBody User request) {
        User user = this.userRepository.findOne(userId);
        if (user != null) {
            user.setFirstname(request.getFirstname());
            user.setLastname(request.getLastname());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setPassword(request.getPassword());
            userRepository.save(user);
        } else {
            throw new RuntimeException("NO such User exists");
        }
    }

    @RequestMapping(path = "api/users/{userId}", method = RequestMethod.GET, produces = "application/json")
    public User findUser(@PathVariable("userId") String userId) {
        return this.userRepository.findOne(userId);
    }

    @RequestMapping(path = "api/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") String userId) {
        User user = this.userRepository.findOne(userId);
        if (user != null) {
            userRepository.delete(userId);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    
    @RequestMapping(path = "api/users/lastname/{lastName}", method = RequestMethod.GET, produces = "application/json")
    public List<User> findByLastName(@PathVariable("lastName") String lastName) {
        
        List<User> response = new ArrayList<User>();
        
        for (User user: userRepository.findAll()) {
            
            if(user.getLastname().equals(lastName)) {
                
                response.add(user);
            
            }
            
        }
        
        return response;
    }
    
    @RequestMapping(path = "api/users/email/like/{email}", method = RequestMethod.GET, produces = "application/json")
    public List<User> findByEmail(@PathVariable("email") String email) {
        
        List<User> response = new ArrayList<User>(); 
        
        for (User user: userRepository.findAll()) {
            
            if(user.getEmail().contains("@"+email+".")) {
                response.add(user);
            }
            
        }        
        return response;
    }
    
    @RequestMapping(path = "api/users/firstname/like/name/{name}", method = RequestMethod.GET, produces = "application/json")
    public List<User> findByName(@PathVariable("name") String name) {
        
        List<User> response = new ArrayList<User>(); 
        
        for (User user: userRepository.findAll()) {
            
            if(user.getFirstname().toLowerCase().startsWith(name.toLowerCase())) {
                response.add(user);
            }
            
        }        
        return response;
    }

}
