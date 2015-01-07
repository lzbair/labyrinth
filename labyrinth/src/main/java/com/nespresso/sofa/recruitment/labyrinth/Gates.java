package com.nespresso.sofa.recruitment.labyrinth;

import static java.util.Collections.unmodifiableList;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class Gates {
	private final List<Gate> gates;

	public Gates(List<Gate> gates) {
		this.gates = unmodifiableList(gates);
	}

	public boolean canCross(Room source, Room target) {
		Gate gate = findGate(source, target);
		if (gate == null) {
			throw new IllegalMoveException();
		}
		if (gate.isClosed()) {
			throw new ClosedDoorException();
		}
		return true;
	}

	public void closeDoor(Room source, Room target) {
		Gate gate = findGate(source, target);
		gate.close();

	}

	public String readSensor(Room source, Room target) {
		return findGate(source, target).readSensor();
	}

	private Gate findGate(Room r1, Room r2) {
		final Gate gate = new Gate(r1, r2);
		Predicate<Gate> gateFinder = new Predicate<Gate>() {
			public boolean apply(Gate g) {
				return gate.equals(g);
			};
		};
		return Iterables.find(this.gates, gateFinder, null);
		
	}
}