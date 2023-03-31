package com.dao;

import java.sql.Date;
import java.util.List;

import com.dto.CriminalDto;

public interface CriminalDao {
	public boolean addCriminal(CriminalDto criminal);
	public boolean updateCriminal(int criminal_id, String name, Date date, String gender, String mark, Date first_arrest, String arrestArea);
	public boolean assignCrime(int crime_id, int criminal_id);
	public boolean removeCrime(int crime_d, int criminal_id);
	public boolean deleteCriminal(int criminal_id);
	public List<CriminalDto> searchCriminalByName(String name);
	public CriminalDto searchCriminalByDescription(String desc);
}
