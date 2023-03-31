package com.exception;

public class CrimeNotFoundException extends Exception{
	public CrimeNotFoundException() {
		System.out.println("Crime Not Found");
	}
}
