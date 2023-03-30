package com.dao;

import java.sql.Date;

import com.dto.CrimeDto;

public interface CrimeDao {
	public boolean addCrime(CrimeDto crime);
	public boolean updateCrime(int crime_id, String desc, String name, String area, Date date, String type);
	public boolean deleteCrime(int crime_id);
	public void showTotalCrimeForEachPS(Date start, Date end);
	public void showTotalCrimeForType(Date start, Date end);
}
