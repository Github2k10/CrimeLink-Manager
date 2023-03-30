package com.dao;

import java.sql.Date;

import com.dto.CrimeDto;

public class CrimeDaoImp implements CrimeDao{
	
	public CrimeDaoImp() {}

	@Override
	public boolean addCrime(CrimeDto crime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCrime(int crime_id, String desc, String name, String area, Date date, String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCrime(int crime_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showTotalCrimeForEachPS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showTotalCrimeForDateRange(Date start, Date end) {
		// TODO Auto-generated method stub
		
	}

}
