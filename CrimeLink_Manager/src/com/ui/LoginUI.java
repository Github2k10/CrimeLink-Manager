package com.ui;

import java.util.Scanner;

public class LoginUI {
	private static final String userid;
	private static final String password;
	
	static {
		userid = "admin";
		password = "admin";
	}
	
	static void LoginAdmin(Scanner sc) {
		ColorLogger logger = new ColorLogger();
		
		logger.printInfo("Enter username: ");
		String usename = sc.nextLine();
		
		logger.printInfo("Enter password: ");
		String passcode = sc.nextLine();
		
		if(userid.equals(usename)) {
			if(password.equals(passcode)) {
				logger.printlnInfo("\n\n********************************************************");
				logger.printlnInfo("           Login successfully as Block Admin           ");
				logger.printlnInfo("********************************************************\n");
				AdminUI.adminLogin(sc);
			} else {
				logger.printlnError("\n\n**********************************");
				logger.printlnError("        Password Wrong!!!           ");
				logger.printlnError("**********************************\n");
			}
		} else {
			logger.printlnError("\n\n******************************");
			logger.printlnError("        User ID wrong           ");
			logger.printlnError("******************************\n");
		}		
	}
}
