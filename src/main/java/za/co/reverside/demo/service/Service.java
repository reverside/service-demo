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

	@RequestMapping(path="api/users/{userId}", method=RequestMethod.PUT, consumes="application/json")
	public void updateUser(@PathVariable String userId, @RequestBody User request){
		User user = this.userRepository.findOne(userId);
		if(user != null){
			user.setName(request.getName());
			user.setSurname(request.getSurname());
			user.setPassword(request.getPassword());
			userRepository.save(user);
		}
		else {
			throw new RuntimeException("NO such User exists");
		}
	}

}