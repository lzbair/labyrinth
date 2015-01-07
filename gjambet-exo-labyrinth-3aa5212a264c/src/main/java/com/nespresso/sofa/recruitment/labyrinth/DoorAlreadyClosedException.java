package com.nespresso.sofa.recruitment.labyrinth;

@SuppressWarnings("serial")
public class DoorAlreadyClosedException extends RuntimeException {

	public DoorAlreadyClosedException() {
		super();
	}

	public DoorAlreadyClosedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DoorAlreadyClosedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoorAlreadyClosedException(String message) {
		super(message);
	}

	public DoorAlreadyClosedException(Throwable cause) {
		super(cause);
	}

}
