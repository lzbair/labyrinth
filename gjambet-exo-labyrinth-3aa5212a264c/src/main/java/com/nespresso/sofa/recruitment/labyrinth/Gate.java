package com.nespresso.sofa.recruitment.labyrinth;

import java.util.Arrays;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public class Gate {

	private final List<Room> rooms;
	private State currentState = State.OPEN;
	private final boolean isMonitored = false;

	public Gate(Room r1, Room r2) {
		this.rooms = unmodifiableList((Arrays.asList(r1, r2)));
	}
	
	public Gate(Room r1, Room r2, boolean isMonitored) {
		this.Gate(r1, r2);
		this.isMonitored = isMonitored;
	}


	public void close() {
		if (this.currentState == State.CLOSED) {
			throw new DoorAlreadyClosedException();
		}
		this.currentState = State.CLOSED;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(rooms.get(0)).append(rooms.get(1))
				.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gate other = (Gate) obj;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.contains(other.rooms.get(0))
				|| !rooms.contains(other.rooms.get(1)))
			return false;

		return true;
	}


	public boolean isClosed() {
		return this.currentState == State.CLOSED;
	}

	private enum State {
		OPEN, CLOSED;
	}

	public String readSensor() {
		// TODO Auto-generated method stub
		return null;
	}
}
