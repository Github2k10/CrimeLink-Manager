package com.ui;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.CrimeDao;
import com.dao.CrimeDaoImp;
import com.dao.CriminalDao;
import com.dao.CriminalDaoImp;
import com.dto.CrimeDto;
import com.dto.CrimeDtoImp;
import com.dto.CriminalDto;
import com.dto.CriminalDtoImp;
import com.exception.CrimeNotFoundException;
import com.exception.CriminalNotFoundException;
import com.exception.InvalidDataException;
import com.exception.SomeThingWentWrongException;

public class AdminUI {
	static void adminLogin(Scanner sc) {
		int choise = 98;
		ColorLogger logger = new ColorLogger();
		CrimeDao crimeDao = new CrimeDaoImp();
		CriminalDao criminalDao = new CriminalDaoImp();
		
		do {
			logger.printlnDebug("\n1. Add a crime\n"
					+ "2. Update crime\n"
					+ "3. Add criminal\n"
					+ "4. Update criminal\n"
					+ "5. Assign criminals to crime\n"
					+ "6. Remove criminal from crime\n"
					+ "7. Delete crime\n"
					+ "8. Delete criminal\n"
					+ "9. Show all Crime list\n"
					+ "10. Show all Criminal list\n"
					+ "0. Exit");
			
			logger.printDebug("\nEnter Selection: ");
			choise = Integer.parseInt(sc.nextLine());
			
			switch(choise) {
				case 1:{
					logger.printDebug("\nEnter crime description: ");
					String desc = sc.nextLine();
					
					logger.printDebug("Enter victim name: ");
					String name = sc.nextLine();
					
					logger.printDebug("Enter Police Station area: ");
					String ps = sc.nextLine();
					
					logger.printDebug("Enter crime date(YYYY-MM-DD): ");
					Date date = Date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter type of crime(Robbery, Theft, Homicide): ");
					String type = sc.nextLine();
					
					try {
						Boolean out = crimeDao.addCrime(new CrimeDtoImp(desc, name, ps, date, type));
						
						if(out)
							logger.printlnInfo("\nCrime added Successfully");
						else 
							logger.printlnError("\nFailed to Add crime!!!");
					} catch (SomeThingWentWrongException | InvalidDataException e) {
						logger.printlnError(e.getMessage());
					}
 				}
					
					break;
					
				case 2:{
					logger.printDebug("\nEnter crime id: ");
					int id = Integer.parseInt(sc.nextLine());
					
					logger.printDebug("Enter crime description: ");
					String desc = sc.nextLine();
					
					logger.printDebug("Enter victim name: ");
					String name = sc.nextLine();
					
					logger.printDebug("Enter Police Station area: ");
					String ps = sc.nextLine();
					
					logger.printDebug("Enter crime date(YYYY-MM-DD): ");
					Date date = Date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter type of crime(Robbery, Theft, Homicide): ");
					String type = sc.nextLine();
					
					try {
						Boolean out = crimeDao.updateCrime(id, desc, name, ps, date, type);
						
						if(out)
							logger.printlnInfo("\nCrime Updated Successfully");
						else 
							logger.printlnError("\nFailed to Update crime!!!");
					} catch (SomeThingWentWrongException | InvalidDataException | CrimeNotFoundException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 3:{
					logger.printDebug("\nEnter Criminal Name: ");
					String name = sc.nextLine();
					
					logger.printDebug("Enter date of birth: ");
					Date date = Date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter gender: ");
					String gender = sc.nextLine();
					
					logger.printDebug("Enter identifying Mark: ");
					String mark = sc.nextLine();
					
					logger.printDebug("Enter first arrest date: ");
					Date arrest = date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter police station name: ");
					String ps = sc.nextLine();
					
					
					try {
						boolean out = criminalDao.addCriminal(new CriminalDtoImp(name, date, gender, mark, arrest, ps));
						
						if(out)
							logger.printlnInfo("\nCriminal added Successfully");
						else 
							logger.printlnError("\nFailed to Add Criminal!!!");
					} catch (SomeThingWentWrongException | InvalidDataException e) {
						logger.printlnError(e.getMessage());
					}
				}
					break;
					
				case 4:{
					logger.printDebug("Enter criminal Id: ");
					int id = Integer.parseInt(sc.nextLine());
					
					logger.printDebug("\nEnter Criminal Name: ");
					String name = sc.nextLine();
					
					logger.printDebug("Enter date of birth: ");
					Date date = Date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter gender: ");
					String gender = sc.nextLine();
					
					logger.printDebug("Enter identifying Mark: ");
					String mark = sc.nextLine();
					
					logger.printDebug("Enter first arrest date: ");
					Date arrest = date.valueOf(sc.nextLine());
					
					logger.printDebug("Enter police station name: ");
					String ps = sc.nextLine();
					
					
					try {
						boolean out = criminalDao.addCriminal(new CriminalDtoImp(id, name, date, gender, mark, arrest, ps));
						
						if(out)
							logger.printlnInfo("\nCriminal Updated Successfully");
						else 
							logger.printlnError("\nFailed to update Criminal!!!");
					} catch (SomeThingWentWrongException | InvalidDataException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 5:{
					logger.printDebug("\nEnter criminal id: ");
					int criminal = Integer.parseInt(sc.nextLine());
					
					logger.printDebug("Enter crime id: ");
					int crime = Integer.parseInt(sc.nextLine());
					
					try {
						boolean out = criminalDao.assignCrime(criminal, crime);
						
						if(out)
							logger.printlnInfo("\nCrime assigned Successfully");
						else 
							logger.printlnError("\nFailed to Crime assign!!!");
					} catch (CriminalNotFoundException | SomeThingWentWrongException e) {
						logger.printlnDebug(e.getMessage());
					}
				}
					
					break;
					
				case 6:{
					logger.printDebug("\nEnter criminal id: ");
					int criminal = Integer.parseInt(sc.nextLine());
					
					logger.printDebug("Enter crime id: ");
					int crime = Integer.parseInt(sc.nextLine());
					
					try {
						boolean out = criminalDao.removeCrime(criminal, crime);
						
						if(out)
							logger.printlnInfo("\nCrime removed Successfully");
						else 
							logger.printlnError("\nFailed to removed assign!!!");
					} catch (CriminalNotFoundException | SomeThingWentWrongException e) {
						logger.printlnDebug(e.getMessage());
					}
				}
					
					break;
					
				case 7:{
					logger.printDebug("Enter crime id: ");
					int crime = Integer.parseInt(sc.nextLine());
					
					try {
						boolean out = crimeDao.deleteCrime(crime);
						
						if(out)
							logger.printlnInfo("\nCrime deleted Successfully");
						else 
							logger.printlnError("\nFailed to delete assign!!!");
					} catch (SomeThingWentWrongException | CrimeNotFoundException e) {
						logger.printlnDebug(e.getMessage());
					}
				}
					
					break;
					
				case 8:{
					logger.printDebug("\nEnter criminal id: ");
					int criminal = Integer.parseInt(sc.nextLine());
					
					try {
						boolean out = criminalDao.deleteCriminal(criminal);
						
						if(out)
							logger.printlnInfo("\nCriminal deleted Successfully");
						else 
							logger.printlnError("\nFailed to delete criminal!!!");
					} catch (CriminalNotFoundException | SomeThingWentWrongException e) {
						logger.printlnDebug(e.getMessage());
					}
				}
					
					break;
					
				case 9:{
					try {
						List<CrimeDto> list = crimeDao.showAllCrime();
						
						System.out.println();
						
						for(CrimeDto c : list) {
							System.out.println();
							logger.printlnInfo(c.toString());
						}
						
						System.out.println();
					} catch (CrimeNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
				}
					
					break;
					
				case 10: {
					try {
						List<CriminalDto> list = criminalDao.showAllCriminal();
						
						System.out.println();
						
						for(CriminalDto c : list) {
							System.out.println();
							logger.printlnInfo(c.toString());
						}
						
						System.out.println();
					} catch (CriminalNotFoundException | SomeThingWentWrongException e) {
						logger.printlnError(e.getMessage());
					}
					
				} 
				
					break;
					
				case 0: 	break;
					
				default :
					logger.printlnError("\\nUnexpected value!!!\\n");
			}
			
			
		} while (choise != 0);
	}
}
