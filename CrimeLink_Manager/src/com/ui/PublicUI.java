package com.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CrimeDao;
import com.dao.CrimeDaoImp;
import com.dao.CriminalDao;
import com.dao.CriminalDaoImp;
import com.dto.CrimeDto;
import com.dto.CriminalDto;
import com.exception.CrimeNotFoundException;
import com.exception.CriminalNotFoundException;
import com.exception.SomeThingWentWrongException;

public class PublicUI {
	static void publicLogin(Scanner sc) {
		int choise = 98;
		ColorLogger logger = new ColorLogger();
		CrimeDao crimeDao = new CrimeDaoImp();
		CriminalDao criminalDao = new CriminalDaoImp();
		
		logger.printlnInfo("\n\n********************************************************");
		logger.printlnInfo("               Login with public account           ");
		logger.printlnInfo("********************************************************\n");
		
		do {
			logger.printlnDebug("\n1. View total crime for each police station area for a date range\n"
					+ "2. View total crime for each crime type for a date range.\n"
					+ "3. Search for criminal by name\n"
					+ "4. Search for crime by description\n"
					+ "0. Exit");
			
			logger.printDebug("Enter Selection: ");
			choise = Integer.parseInt(sc.nextLine());
			
			switch(choise) {
				case 1:{
					
					logger.printDebug("\nEnter starting year: ");
					String start = sc.nextLine();
					
					logger.printDebug("Enter ending year: ");
					String end = sc.nextLine();
					
					try {
						crimeDao.showTotalCrimeForEachPS(start, end);
					} catch (CrimeNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 2:{
					logger.printDebug("\nEnter starting year: ");
					String start = sc.nextLine();
					
					logger.printDebug("Enter ending year: ");
					String end = sc.nextLine();
					
					try {
						crimeDao.showTotalCrimeForTypeAndDateRange(start, end);
					} catch (CrimeNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 3:{
					logger.printDebug("Enter criminal name: ");
					String name = sc.nextLine();
					
					try {
						List<CriminalDto> list = criminalDao.searchCriminalByName(name);
						System.out.println();
						for(CriminalDto c : list) {
							logger.printlnInfo(c.toString());
						}
						
						System.out.println();
					} catch (CriminalNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 4:{
					logger.printDebug("Enter crime description: ");
					String desc = sc.nextLine();
					
					try {
						List<CrimeDto> list = crimeDao.searchCrimeByDescription(desc);
						System.out.println();
						
						for(CrimeDto c : list) {
							logger.printlnInfo(c.toString());
						}
						
						System.out.println();
					} catch (CrimeNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 0:
					
					break;
					
				default :
					logger.printlnError("\\nUnexpected value!!!\\n");
			}
			
			
		} while (choise != 0);
	}
}
