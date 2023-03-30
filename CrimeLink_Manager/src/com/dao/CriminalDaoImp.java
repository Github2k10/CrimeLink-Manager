package com.dao;

import java.sql.Date;

import com.dto.CriminalDto;

public class CriminalDaoImp implements CriminalDao{
	public CriminalDaoImp() {}

	@Override
	public boolean addCriminal(CriminalDto criminal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCriminal(int criminal_id, String name, Date date, String gender, String mark,
			Date first_arrest, String arrestArea) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean assignCrime(int crime_id, int criminal_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCrime(int crime_d, int criminal_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCriminal(int criminal_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CriminalDto searchCriminalByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriminalDto searchCriminalByDescription(String desc) {
		// TODO Auto-generated method stub
		return null;
	}

}
