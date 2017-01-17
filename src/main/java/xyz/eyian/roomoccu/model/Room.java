package xyz.eyian.roomoccu.model;

public class Room {
	private int id;
	private String room;
	private String etage;
	
	public Room(){
		super();
	}
	
	public Room(int id, String room, String etage){
		super();
		this.id = id;
		this.room = room;
		this.etage = etage;
	}

	// Getters Setters \\
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}
}
