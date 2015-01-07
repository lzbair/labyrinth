package com.nespresso.sofa.recruitment.labyrinth;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class RoomTracker {

	private final Gates gates;
	private final List<Room> path;

	public RoomTracker(List<Gate> gates) {
		this.gates = new Gates(gates);
		this.path = new ArrayList<>();
	}

	public void addToVisitedRooms(Room room) {
		path.add(room);
	}

	public void walkTo(Room target) {
		Room source = path.get(path.size() - 1);
		if (gates.canCross(source, target)) {
			addToVisitedRooms(target);
		}
	}

	

	public void closeLastDoor() {
		Room target = path.get(path.size() - 1);
		Room source = path.get(path.size() - 2);
		gates.closeDoor(source, target);
	}

	public String readSensors() {
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < path.size() - 1) {
			Room target = path.get(i);
			Room source = path.get(i + 1);
			result.add(gates.readSensor(source, target));
			i++;
		}
		return Joiner.on(";").skipNulls().join(result);
	}

}
