package Lab11;


public class Pokemon {
	private int id;
	private String name;
	
	public Pokemon(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		
		return "Id : " + id +" Name : " + name;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Pokemon)){
			return false; 
		}else{
			return this.name.equalsIgnoreCase( ((Pokemon) obj).name);
		}
	}
	@Override
	public int hashCode() {
		return 0;
	}
}

