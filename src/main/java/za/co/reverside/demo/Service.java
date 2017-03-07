package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import za.co.reverside.demo.repository.UserRepository;
import za.co.reverside.demo.model.User;
=======
>>>>>>> 2735cc9739699998d29f50c5e6a1209094e82d80

@RestController
public class Service{

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="api/hello")
	public String hello(){
		return "Hello world";
	}
	
	@RequestMapping(path="api/users", method=RequestMethod.POST, consumes="application/json")
	public void createUser(@RequestBody User user){
		this.userRepository.insert(user);
	}

	@RequestMapping(path="api/users", method=RequestMethod.GET, produces="application/json")
	public List<User> findUsers(){
		return this.userRepository.findAll();
	}

}