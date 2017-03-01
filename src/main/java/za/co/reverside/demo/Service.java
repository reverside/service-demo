package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Service{

private	List<Car> cars = new ArrayList<Car>();

	@RequestMapping(value="api/hello")
	public String hello(){
		return "Hello world";
	}

	@RequestMapping(path="api/cars", method=RequestMethod.POST, consumes="application/json")
	public void createCars(@RequestBody Car car){
		this.cars.add(car);
	}

	@RequestMapping(path="api/cars", method=RequestMethod.GET, produces="application/json")
	public List<Car> findAll(){
		return this.cars;
	}

}