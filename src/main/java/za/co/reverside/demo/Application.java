package za.co.reverside.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import com.mangofactory.swagger.plugin.EnableSwagger;

@SpringBootApplication
@EnableSwagger
public class Application{


	public static void main (String [] args){

		SpringApplication.run(Application.class, args);
	} 
}