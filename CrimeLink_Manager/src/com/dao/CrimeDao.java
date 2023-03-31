package com.dao;

import java.sql.Date;
import java.util.List;

import com.dto.CrimeDto;
import com.exception.CrimeNotFoundException;
import com.exception.InvalidDataException;
import com.exception.SomeThingWentWrongExceptioni;

public interface CrimeDao {
	public boolean addCrime(CrimeDto crime) throws SomeThingWentWrongExceptioni, InvalidDataException;
	public boolean updateCrime(int crime_id, String desc, String name, String area, Date date, String type) throws CrimeNotFoundException, InvalidDataException, SomeThingWentWrongExceptioni;
	public boolean deleteCrime(int crime_id) throws CrimeNotFoundException, SomeThingWentWrongExceptioni;
	public void showTotalCrimeForEachPS(Date start, Date end) throws CrimeNotFoundException;
	public void showTotalCrimeForType(Date start, Date end);
	public List<CrimeDto> searchCrimeByDescription(String desc);
}
