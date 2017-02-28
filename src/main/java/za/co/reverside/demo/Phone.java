package za.co.reverside.demo;

public class Phone{

	private int id;
	private String name;
	private String color;
	private String price;

	public Phone(){}

	public Phone(String name, String color, String price, int id){
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getColor(){
		return  this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getPrice(){
		return this.price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}



}