package za.co.reverside.demo;

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
	
	

}