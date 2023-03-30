package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.CriminalDto;

public class CriminalDaoImp implements CriminalDao{
	public CriminalDaoImp() {}

	@Override
	public boolean addCriminal(CriminalDto criminal) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			String query = "inert into criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area  values (?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, criminal.getName());
			statement.setDate(2, criminal.getDob());
			statement.setString(3, criminal.getGender());
			statement.setDate(4, criminal.getDatefirstArrestDate());
			statement.setString(4, criminal.getArrestedPS());
			
			statement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				
			}
		}
		return false;
	}

	@Override
	public boolean updateCriminal(int criminal_id, String name, Date date, String gender, String mark,
			Date first_arrest, String arrestArea) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "update table crime set name = ?, dob = ?, gender = ?, identifying_mark = ?, first_arrest_date = ?, arrested_from_ps_area = ? where criminal_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, date);
			statement.setString(3, gender);
			statement.setString(4, mark);
			statement.setDate(5, first_arrest);
			statement.setString(6, arrestArea);
			statement.setInt(7, criminal_id);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
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
