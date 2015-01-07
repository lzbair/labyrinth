package com.nespresso.sofa.recruitment.labyrinth;

@SuppressWarnings("serial")
public class ClosedDoorException extends RuntimeException {

	public ClosedDoorException() {
		super();
	}

	public ClosedDoorException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClosedDoorException(String message) {
		super(message);
	}

	public ClosedDoorException(Throwable cause) {
		super(cause);
	}

	public ClosedDoorException(String message, Throwable cause) {
		super(message, cause);
	}
}
