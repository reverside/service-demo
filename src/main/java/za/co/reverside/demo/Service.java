package za.co.reverside.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Service{

	private List<Book> books = new ArrayList<Book>();

	@RequestMapping(path="api/hello", method=RequestMethod.GET, produces="text/plain")
	public String hello(){
		return "Hello";
	}

	@RequestMapping(path="api/books", method=RequestMethod.POST, consumes="application/json")
	public void creatNew(Book book){
		System.out.println("size of books before : " + this.books.size());
		this.books.add(book);
		System.out.println("size of books after  : " + this.books.size());

	}



}