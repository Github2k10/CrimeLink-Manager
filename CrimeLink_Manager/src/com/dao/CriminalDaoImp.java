package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CriminalDto;
import com.dto.CriminalDtoImp;
import com.exception.CriminalNotFoundException;
import com.exception.InvalidDataException;
import com.exception.SomeThingWentWrongException;

public class CriminalDaoImp implements CriminalDao{
	private boolean isResultSetEmpty(ResultSet set) throws SQLException {
		if(!set.isBeforeFirst() && set.getRow() == 0) {
			return true;
		}
		
		return false;
	}
	
	private List<CriminalDto> getList(ResultSet set) throws SQLException{
		List<CriminalDto> list = new ArrayList<>();
		
		while(set.next()) {
			CriminalDto dto = new CriminalDtoImp();
			
			dto.setCriminal_id(set.getInt(1));
			dto.setName(set.getString(1));
			dto.setDob(set.getDate(3));
			dto.setGender(set.getString(4));
			dto.setIdentifyingMark(set.getString(5));
			dto.setDatefirstArrestDate(set.getDate(6));
			dto.setArrestedPS(set.getString(7));
			
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public boolean addCriminal(CriminalDto criminal) throws InvalidDataException, SomeThingWentWrongException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			String query = "insert into criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area)  values (?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, criminal.getName());
			statement.setDate(2, criminal.getDob());
			statement.setString(3, criminal.getGender());
			statement.setString(4, criminal.getIdentifyingMark());
			statement.setDate(5, criminal.getDatefirstArrestDate());
			statement.setString(6, criminal.getArrestedPS());
			
			int n = statement.executeUpdate();
			
			if(n == 0) {
				throw new InvalidDataException();
			}
			
			return true;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
	}

	@Override
	public boolean updateCriminal(int criminal_id, String name, Date date, String gender, String mark,
			Date first_arrest, String arrestArea) throws CriminalNotFoundException, SomeThingWentWrongException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "update criminal set name = ?, dob = ?, gender = ?, identifying_mark = ?, first_arrest_date = ?, arrested_from_ps_area = ? where criminal_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, date);
			statement.setString(3, gender);
			statement.setString(4, mark);
			statement.setDate(5, first_arrest);
			statement.setString(6, arrestArea);
			statement.setInt(7, criminal_id);
			
			int n = statement.executeUpdate();
			
			if(n == 0) {
				throw new CriminalNotFoundException();
			}
			
			return true;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
		
	}

	@Override
	public boolean assignCrime(int criminal_id, int crime_id) throws CriminalNotFoundException, SomeThingWentWrongException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "insert into offender values (?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, criminal_id);
			statement.setInt(2, crime_id);
			
			int n = statement.executeUpdate();
			
			if(n == 0) {
				throw new CriminalNotFoundException();
			}
			
			return true;
		} catch (SQLException e) {
			System.out.println("Either criminal id: " + criminal_id + " or crime id: " + crime_id + " not avilabile");
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
	}

	@Override
	public boolean removeCrime(int criminal_id, int crime_id) throws CriminalNotFoundException, SomeThingWentWrongException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "delete from offender where criminal_id = ? and crime_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, criminal_id);
			statement.setInt(2, crime_id);
			
			int n = statement.executeUpdate();
			
			if(n == 0) {
				throw new CriminalNotFoundException();
			}
			
			return true;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
	}

	@Override
	public boolean deleteCriminal(int criminal_id) throws CriminalNotFoundException, SomeThingWentWrongException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "delete from criminal where criminal_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, criminal_id);
			
			int n = statement.executeUpdate();
			
			if(n == 0) {
				throw new CriminalNotFoundException();
			}
			
			return true;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
	}

	@Override
	public List<CriminalDto> searchCriminalByName(String name) throws CriminalNotFoundException, SomeThingWentWrongException {
		Connection connection = null;
		List<CriminalDto> list = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from criminal where name = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultSetEmpty(set)) {
				throw new CriminalNotFoundException(name);
			}
			
			list = getList(set);
			
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
		
		return list;
	}
	
	@Override
	public List<CriminalDto> showAllCriminal() throws CriminalNotFoundException, SomeThingWentWrongException{
		Connection connection = null;
		List<CriminalDto> list = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from criminal";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultSetEmpty(set)) {
				throw new CriminalNotFoundException();
			}
			
			list = getList(set);
			
		} catch (SQLException e) {
			throw new SomeThingWentWrongException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
		
		return list;
	}

}
