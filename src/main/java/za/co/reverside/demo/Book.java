package za.co.reverside.demo;


public class Book{

	private String id;
	private String title;
	private String author;

	public Book(){}

	public Book(String id, String title, String author){
		this.id = id;
		this.title = title;
		this.author = author;
	}
	public String getId(){
		return this.id;
	}

	public void setId (String id){
		this.id = id;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setAuthor(String author){
		this.author = author;
	}
}