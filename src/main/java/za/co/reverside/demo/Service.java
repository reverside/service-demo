package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

	@RequestMapping(path="api/cars/{id}", method=RequestMethod.GET, produces="application/json")
	public Car findOne(@PathVariable("id") String id){
		Car car = null;

		for(Car aCar: cars){
			if(aCar.getId().equals(id))
				car = aCar;
		}
		return car;
	}

	@RequestMapping(path="api/cars/{id}", method=RequestMethod.DELETE)
	public void deleteOne(@PathVariable("id") String id){
		
		Car car = null;

		for(Car aCar: cars){
			if(aCar.getId().equals(id))
				car = aCar;
		}
		this.cars.remove(car);
	}

	@RequestMapping(path="api/cars/{id}", method=RequestMethod.PUT, produces="application/json")
	public void updateOne(@RequestBody Car car, @PathVariable("id") String id){

		for(Car aCar: cars){
			if(aCar.getId().equals(id)){
				car = aCar;
				this.cars.set(Integer.parseInt(id),car);
			}
			
		}
		
	}

}