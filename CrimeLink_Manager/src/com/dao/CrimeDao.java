package com.dao;

import java.sql.Date;
import java.util.List;

import com.dto.CrimeDto;
import com.exception.CrimeNotFoundException;
import com.exception.InvalidDataException;
import com.exception.SomeThingWentWrongExceptioni;

public interface CrimeDao {
	public boolean addCrime(CrimeDto crime) throws SomeThingWentWrongExceptioni;
	public boolean updateCrime(int crime_id, String desc, String name, String area, Date date, String type) throws CrimeNotFoundException, InvalidDataException, SomeThingWentWrongExceptioni;
	public boolean deleteCrime(int crime_id);
	public void showTotalCrimeForEachPS(Date start, Date end);
	public void showTotalCrimeForType(Date start, Date end);
	public List<CrimeDto> searchCrimeByDescription(String desc);
}
