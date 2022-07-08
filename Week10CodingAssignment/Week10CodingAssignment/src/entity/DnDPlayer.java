package entity;

public class DnDPlayer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String race;
	private String classes;
	
	
	public DnDPlayer(int id,String firstName, String lastName, String race, String classes) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setRace(race);
		this.setClasses(classes);
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

}
