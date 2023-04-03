package com.dao;

import java.sql.Date;
import java.util.List;

import com.dto.CrimeDto;
import com.exception.CrimeNotFoundException;
import com.exception.InvalidDataException;
import com.exception.SomeThingWentWrongException;

public interface CrimeDao {
	public boolean addCrime(CrimeDto crime) throws SomeThingWentWrongException, InvalidDataException;
	public boolean updateCrime(int crime_id, String desc, String name, String area, Date date, String type) throws CrimeNotFoundException, InvalidDataException, SomeThingWentWrongException;
	public boolean deleteCrime(int crime_id) throws CrimeNotFoundException, SomeThingWentWrongException;
	public void showTotalCrimeForEachPS(String start, String end) throws CrimeNotFoundException, SomeThingWentWrongException;
	public void showTotalCrimeForTypeAndDateRange(String start, String end) throws  SomeThingWentWrongException, CrimeNotFoundException;
	public List<CrimeDto> searchCrimeByDescription(String desc) throws CrimeNotFoundException, SomeThingWentWrongException;
	public List<CrimeDto> showAllCrime() throws CrimeNotFoundException, SomeThingWentWrongException;
}
