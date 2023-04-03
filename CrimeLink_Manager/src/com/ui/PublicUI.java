package com.ui;

import java.util.Scanner;

public class PublicUI {
	static void publicLogin(Scanner sc) {
		int choise = 98;
		ColorLogger logger = new ColorLogger();
		
		do {
			logger.printlnDebug("\n1. View total crime for each police station area for a date range\n"
					+ "2. View total crime for each crime type for a date range.\n"
					+ "3. Search for criminal by name\n"
					+ "4. Search for crime by description\n"
					+ "0. Exit");
			
			logger.printDebug("Enter Selection: ");
			choise = Integer.parseInt(sc.nextLine());
			
			switch(choise) {
				case 1:
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					
					break;
					
				case 0:
					
					break;
					
				default :
					logger.printlnError("\\nUnexpected value!!!\\n");
			}
			
			
		} while (choise != 0);
	}
}
