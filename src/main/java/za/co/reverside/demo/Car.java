package za.co.reverside.demo;

public class Car{

	private int id;
	private int engineSize;
	private String name;
	private String color;

	public Car(){}

	public Car(int id, int engineSize, String name, String color){
		this.id = id;
		this.engineSize = engineSize;
		this.name = name;
		this.color = color;

	}


	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getEngineSize(){
		return this.engineSize;
	}
	public void setEngineSize(int engineSize){
		this.engineSize = engineSize;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color = color;
	}

}