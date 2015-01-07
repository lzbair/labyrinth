package com.nespresso.sofa.recruitment.labyrinth;



public class Labyrinth {
	

	private final RoomTracker roomTracker;

	public Labyrinth(String... gates) {
		this.roomTracker = new RoomTracker(gates);
	}

	

	public void popIn(String id) {
		roomTracker.addToVisitedRooms(new Room(id));
		
	}

	public void walkTo(String id) {
		roomTracker.walkTo(new Room(id));
		
	}

	public void closeLastDoor() {
		roomTracker.closeLastDoor();
		
	}

	public String readSensors() {
		return roomTracker.readSensors();
	}

	
}
