package com.dto;

import java.sql.Date;

public class CrimeDtoImp implements CrimeDto{
	private int crime_id;
	private String desc;
	private String victim_name;
	private String ps_area;
	private Date date;
	private String type;
	
	public CrimeDtoImp() {}

	public CrimeDtoImp(int crime_id, String desc, String victim_name, String ps_area, Date date, String type) {
		this.crime_id = crime_id;
		this.desc = desc;
		this.victim_name = victim_name;
		this.ps_area = ps_area;
		this.date = date;
		this.type = type;
	}
	
	
}
