package za.co.reverside.demo;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger
@SpringBootApplication
public class Application{


	public static void main (String [] args){
		SpringApplication.run(Application.class, args);
	} 
	
}