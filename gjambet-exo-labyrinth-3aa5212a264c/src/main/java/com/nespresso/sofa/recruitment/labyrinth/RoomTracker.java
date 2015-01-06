package com.nespresso.sofa.recruitment.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class RoomTracker {

	private final List<Room> path = new ArrayList<>();

	public void addToVisitedRooms(Room room) {
		path.add(room);
	}

	public void walkTo(Room target, Gates gates) {
		Room source = this.getLastVisitedRoom();
		if (gates.canCross(source, target)) {
			addToVisitedRooms(target);
		}
	}

	private Room getLastVisitedRoom() {
		return path.get(path.size() - 1);
	}

	public void closeLastDoor(Gates gates) {
		Room source = path.get(path.size() - 2);
		Room target = this.getLastVisitedRoom();
		gates.closeDoor(source, target);
	}

	public String readSensors(Gates gates) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < path.size()) {
			Room target = path.get(i);
			Room source = path.get(i + 1);
			result.append(gates.readSensor(source, target));
			i = i + 2;
		}
		return result.toString();
	}

}
