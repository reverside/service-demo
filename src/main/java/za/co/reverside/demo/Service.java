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

  


}