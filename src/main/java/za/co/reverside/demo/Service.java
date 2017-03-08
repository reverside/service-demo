package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Service{

	@RequestMapping(value="api/hello")
	public String hello(){
		return "Hello world";
	}
	

}