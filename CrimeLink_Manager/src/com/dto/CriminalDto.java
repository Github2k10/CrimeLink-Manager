package com.dto;

import java.sql.Date;

public interface CriminalDto {
	public int getCriminal_id();

	public void setCriminal_id(int criminal_id);

	public String getName();

	public void setName(String name);

	public Date getDob();

	public void setDob(Date dob);

	public String getGender();

	public void setGender(String gender);

	public String getIdentifyingMark();

	public void setIdentifyingMark(String identifyingMark);

	public Date getDatefirstArrestDate();

	public void setDatefirstArrestDate(Date datefirstArrestDate);

	public String getArrestedPS();

	public void setArrestedPS(String arrestedPS);
}
