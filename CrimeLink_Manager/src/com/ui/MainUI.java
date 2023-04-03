package com.ui;

import java.util.Scanner;

public class MainUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ColorLogger logger = new ColorLogger();
		
		logger.printlnInfo("**************************************************************");
		logger.printlnInfo("               Welcome To CrimeLink Manager");
		logger.printlnInfo("**************************************************************\n\n");
		
		int choise = 98;
		
		do {
			logger.printlnDebug("1. Login as Admin\n2. Login as public\n0. Exit");
			logger.printDebug("Enter selection: ");
			
			try {
				choise = Integer.parseInt(scanner.nextLine());				
			} catch (Exception e) {}
			
			
			switch (choise) {
			case 1:
				LoginUI.LoginAdmin(scanner);
				break;
				
			case 2:
				PublicUI.publicLogin(scanner);
				break;
				
			case 0:
				break;
				
			default:
				logger.printlnError("\nUnexpected value!!!\n");
			}
		} while (choise != 0);
		
		logger.printlnInfo("\n\n****************************************************************");
		logger.printlnInfo("                  Thank you for visting");
		logger.printlnInfo("****************************************************************\n");
		
		System.exit(0);
		scanner.close();
	}

}
