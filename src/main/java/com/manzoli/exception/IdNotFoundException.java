package com.manzoli.exception;

public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = -415674305933266226L;

	public IdNotFoundException() {

	}

	public IdNotFoundException(String message) {
		super(message);
	}
}
