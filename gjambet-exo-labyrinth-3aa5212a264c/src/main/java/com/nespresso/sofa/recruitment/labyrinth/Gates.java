package com.nespresso.sofa.recruitment.labyrinth;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public class Gates {
	private final List<Gate> gates;

	public Gates(String... gates) {
		this.gates = unmodifiableList(GatesFactory.create(gates));
	}

	public boolean canCross(Room source, Room target) {
		Gate gate = findFor(source, target);
		if (gate == null) {
			return false;
		}
		if(gate.isClosed()){
			throw new ClosedDoorException();
		}
		return true;
	}

	private Gate findFor(Room r1, Room r2) {
		Gate gate = new Gate(r1, r2);
		for (Gate g : this.gates) {
			if (gate.equals(g))
				return g;
		}
		return null;
	}

	public void closeDoor(Room source, Room target) {
		Gate gate = findFor(source, target);
		gate.close();
		
	}

	public String readSensor(Room source, Room target) {
		Gate gate = findFor(source, target);
		return gate.readSensor();
	}
}