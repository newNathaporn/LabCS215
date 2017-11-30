package Lab9;
import java.io.Serializable;

public class Person implements Serializable{
	private  static  long serialVersionUID = 1L;
	private String name;
	private String id;
	
	public Person(String name,String id) {
		this.name = name;
		this.id = id;
		
	}

	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}

	
	
}
