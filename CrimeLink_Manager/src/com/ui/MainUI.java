package com.ui;

import java.sql.Date;
import java.util.List;

import com.dao.CrimeDao;
import com.dao.CrimeDaoImp;
import com.dao.CriminalDao;
import com.dao.CriminalDaoImp;
import com.dto.CrimeDto;
import com.dto.CriminalDto;
import com.exception.CrimeNotFoundException;
import com.exception.CriminalNotFoundException;
import com.exception.SomeThingWentWrongException;

public class MainUI {

	public static void main(String[] args) {
		CriminalDao criminalDao = new CriminalDaoImp();
		CrimeDao crimeDao = new CrimeDaoImp();
		
		try {
			crimeDao.showTotalCrimeForEachPS("2011", "2014");
		} catch (SomeThingWentWrongException | CrimeNotFoundException e) {
			System.out.print(e.getMessage());
		}
	}

}
