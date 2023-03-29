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

	@Override
	public int getCrime_id() {
		return crime_id;
	}

	@Override
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String getVictim_name() {
		return victim_name;
	}

	@Override
	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}

	@Override
	public String getPs_area() {
		return ps_area;
	}

	@Override
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Crime Crime id = " + crime_id + ", Description = " + desc + ", Victim name = " + victim_name + ", Polish Static area = "
				+ ps_area + ", Date of crime = " + date + ", Crime Type = " + type;
	}
	
}
