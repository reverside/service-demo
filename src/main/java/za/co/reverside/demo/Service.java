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

	


   @RequestMapping(path = "api/books", method=RequestMethod.GET, produces="application/json")
   public List<Book> getBooks(){
   	  List<Book> books = new ArrayList<Book>();
   	  books.add(new Book("1", "X", "A"));
   	  books.add(new Book("2", "Y", "A"));
   	  books.add(new Book("3", "Z", "B"));
   	  return books;
   }


   @RequestMapping(path="api/books/{id}", method=RequestMethod.GET, produces="application/json")
   public Book getBook(@PathVariable("id") String id){
   	    System.out.println("Search Book with ID : " + id);
   	    Book book = new Book();
   	    book.setId(id);
   	    book.setTitle("The Hobbit");
   	    book.setAuthor("Manmay Mohanty");
   		return book;
   }

   @RequestMapping(path = "api/books", method= RequestMethod.POST, consumes="application/json")
   public void createBook(@RequestBody Book book){
   	System.out.println("Received New Book Request :");
      System.out.println(book.getId());
      System.out.println(book.getTitle());
      System.out.println(book.getAuthor());
   }

   //Getting list of phones
   @RequestMapping(path="api/phones", method=RequestMethod.GET, produces="application/json")
   public List<Phone> getPhone(){
      List<Phone> phones = new ArrayList<Phone>();
      phones.add(new Phone("Huawie","Black","1000.00",2222));
      phones.add(new Phone("iPhone 7", "White", "1090.22", 123));
      phones.add(new Phone("Samsung", "Gold", "1000.22", 125));
      phones.add(new Phone("Honeywell", "Black", "1060.22", 520));
      phones.add(new Phone("Nokia", "White", "1020.22", 8520));

      return phones;
   }

   //Creating a new phone item
   @RequestMapping(path = "api/phone", method= RequestMethod.POST, consumes="application/json")
   public void createPhone(@RequestBody Phone phone){
      System.out.println("Received New Phone request :");
      System.out.println(phone.getName());
      System.out.println(phone.getColor());
      System.out.println(phone.getPrice());
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