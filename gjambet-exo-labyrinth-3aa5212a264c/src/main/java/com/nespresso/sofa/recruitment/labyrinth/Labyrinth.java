package com.nespresso.sofa.recruitment.labyrinth;

import java.math.BigDecimal;


public class Labyrinth {
	

	private final Gates gates;
	private final RoomTracker roomTracker;

	public Labyrinth(String... gates) {
		this.gates = new Gates(gates);
		this.roomTracker = new RoomTracker();
	}

	

	public void popIn(String id) {
		roomTracker.addToVisitedRooms(new Room(id));
		
	}

	public void walkTo(String id) {
		roomTracker.walkTo(new Room(id), this.gates);
		
	}

	public void closeLastDoor() {
		roomTracker.closeLastDoor(this.gates);
		
	}

	public String readSensors() {
		return roomTracker.readSensors(this.gates);
	}

	
}
