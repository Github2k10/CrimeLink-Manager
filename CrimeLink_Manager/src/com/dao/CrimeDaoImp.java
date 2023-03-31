package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CrimeDto;
import com.dto.CrimeDtoImp;

public class CrimeDaoImp implements CrimeDao{
	private boolean isResultSetEmpty(ResultSet set) throws SQLException {
		if(set.isBeforeFirst() && set.getRow() == 0) {
			return true;
		}
		
		return false;
	}
	
	private void showList(ResultSet set) throws SQLException {
		System.out.println();
		while(set.next()) {
			System.out.println("Police Station: " + set.getString(1) + ", Total no. of crime: " + set.getInt(2));
		}
		
		System.out.println();
	}
	
	private List<CrimeDto> getList(ResultSet set) throws SQLException{
		List<CrimeDto> list = new ArrayList<>();
		
		while(set.next()) {
			CrimeDto dto = new CrimeDtoImp();
		}
		
		return list;
	}

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
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "update table crime set description = ?, victim_name =?, ps_area = ?, c_date = ?, type = ? where crime_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, desc);
			statement.setString(2, name);
			statement.setString(3, area);
			statement.setDate(4, date);
			statement.setString(5, type);
			statement.setInt(6, crime_id);
			
			statement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteCrime(int crime_id) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "delete from crime where crime_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, crime_id);
			
			statement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void showTotalCrimeForEachPS(Date start, Date end) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select ps_area, count(*) from crime where c_date >= ? and c_date <= ? group by ps_area";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDate(1, start);
			statement.setDate(2, end);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultSetEmpty(set)) {
				
			}
			
			showList(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void showTotalCrimeForType(Date start, Date end) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select type, count(*) from crime where c_date >= ? and c_date <= ? group by type";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDate(1, start);
			statement.setDate(2, end);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultSetEmpty(set)) {
				
			}
			
			showList(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<CrimeDto> searchCrimeByDescription(String desc) {
		Connection connection = null;
		List<CrimeDto> list = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from criminal where ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultSetEmpty(set)) {
				
			}
			
			list = getList(set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
