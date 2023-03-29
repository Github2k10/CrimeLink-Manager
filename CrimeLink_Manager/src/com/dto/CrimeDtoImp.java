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

	public int getCrime_id() {
		return crime_id;
	}

	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getVictim_name() {
		return victim_name;
	}

	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}

	public String getPs_area() {
		return ps_area;
	}

	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Crime Crime id = " + crime_id + ", Description = " + desc + ", Victim name = " + victim_name + ", Polish Static area = "
				+ ps_area + ", Date of crime = " + date + ", Crime Type = " + type;
	}
	
	
	
}
