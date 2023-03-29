package com.dto;

import java.sql.Date;

public interface CrimeDto {
	public int getCrime_id();

	public void setCrime_id(int crime_id);

	public String getDesc();

	public void setDesc(String desc);

	public String getVictim_name();

	public void setVictim_name(String victim_name);

	public String getPs_area();

	public void setPs_area(String ps_area);

	public Date getDate();

	public void setDate(Date date);

	public String getType();

	public void setType(String type);
}
