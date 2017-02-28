package za.co.reverside.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;

@RestController
public class Service {

	
   private List<Phone> phoneList = new ArrayList<Phone>();
   
   //Getting list of phones
   @RequestMapping(path="api/phones", method=RequestMethod.GET, produces="application/json")
   public List<Phone> getPhones(){
      System.out.println("Find All Phones");
      return this.phoneList;
   }

   //Creating a new phone item
   @RequestMapping(path = "api/phone", method= RequestMethod.POST, consumes="application/json")
   public void createPhone(@RequestBody Phone phone){
      System.out.println("Add New Phone");
      this.phoneList.add(phone);
   }

   //Searching for phone by id
   @RequestMapping(path="api/phone/{id}", method=RequestMethod.GET, produces="application/json")
   public Phone searchPhone(@PathVariable("id") int id){
      System.out.println("Search Phone with ID : " + id);
          Phone phone = new Phone();
          phone.setName("Huawie");
          phone.setColor("Black");
          phone.setPrice("2000");
          phone.setId(id);
          
          return phone;
   }
}
