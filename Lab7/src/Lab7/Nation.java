package Lab7;


public enum Nation {
      CHINA("China","Ni Hao"),JAPAN("Japan","Konichiwa"),FRANCE("France","Bonjour"),ITALY("Italy","Ciao"),ENGLISH("English","Hello");
	
	private String NAME;
	private String WORD;
	
	private Nation(String name,String word){
		this.NAME = name;
		this.WORD = word;
	}
	
	public String getName(){
		return NAME;
	}
	
	public String getWord(){
		return WORD;
	}
}
