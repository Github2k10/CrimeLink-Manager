package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.CrimeDto;

public class CrimeDaoImp implements CrimeDao{
	
	public CrimeDaoImp() {}

	@Override
	public boolean addCrime(CrimeDto crime) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			String query = "inert into crime (description, victim_name, ps_area, c_date, type) values (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, crime.getDesc());
			statement.setString(2, crime.getVictim_name());
			statement.setString(3, crime.getPs_area());
			statement.setDate(4, crime.getDate());
			statement.setString(5, crime.getType());
			
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
