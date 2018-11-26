package com.vg.customermanagement.exceptions;

public class CmException extends RuntimeException {

    private static final long serialVersionUID = -7015143634039850539L;

	public CmException(String message) {
		super(message);
	}

    public CmException(String message, Throwable cause) {
        super(message, cause);
    }
}