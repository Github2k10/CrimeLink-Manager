package com.exception;

public class CriminalNotFoundException extends Exception{
	public CriminalNotFoundException() {
		System.out.println("Criminal Not Found");
	}
	
	public CriminalNotFoundException(String message) {
		System.out.println("Criminal Not Found with this name: " + message);
	}
}
