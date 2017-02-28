package za.co.reverside.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Service{

	private List<Book> books = new ArrayList<Book>();

	@RequestMapping(path="api/hello", method=RequestMethod.GET, produces="text/plain")
	public String hello(){
		return "Hello";
	}

	@RequestMapping(path="api/books", method=RequestMethod.POST, consumes="application/json")
	public void creatNew(@RequestBody Book book){
		System.out.println("size of books before : " + this.books.size());
		this.books.add(book);
		System.out.println("size of books after  : " + this.books.size());

	}

	@RequestMapping(path="api/books", method=RequestMethod.GET, produces="application/json")
	public List<Book> findAll() {
		return this.books;
	}

	@RequestMapping(path = "api/books/{id}", method=RequestMethod.GET, produces="application/json")
	public Book findOne(@PathVariable("id") String id){
		Book book = null;
		for(Book aBook : this.books){
			if(aBook.getId().equals(id)){
				book = aBook;
			}
		}
		return book;
	}

	@RequestMapping(path = "api/books/{id}", method=RequestMethod.DELETE, produces="application/json")
	public void deleteOne(@PathVariable("id") String id){
		for(Book aBook : this.books){
			if(aBook.getId().equals(id)){
				this.books.remove(aBook);
			}
		}
	}



}