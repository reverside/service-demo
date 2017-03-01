package za.co.reverside.demo;

public class Car{

	private String id;
	private String engineSize;
	private String name;
	private String color;

	public Car(){}

	public Car(String id, String engineSize, String name, String color){
		this.id = id;
		this.engineSize = engineSize;
		this.name = name;
		this.color = color;

	}


	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getEngineSize(){
		return this.engineSize;
	}
	public void setEngineSize(String engineSize){
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