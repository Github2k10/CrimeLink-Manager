package com.dto;

import java.sql.Date;

public class CriminalDtoImp implements CriminalDto{
		private int criminal_id;
		private String name;
		private Date dob;
		private String gender;
		private String identifyingMark;
		private Date datefirstArrestDate;
		private String arrestedPS;
		
		public CriminalDtoImp() {}
		
		public CriminalDtoImp(int criminal_id, String name, Date dob, String gender, String identifyingMark,
				Date datefirstArrestDate, String arrestedPS) {
			this.criminal_id = criminal_id;
			this.name = name;
			this.dob = dob;
			this.gender = gender;
			this.identifyingMark = identifyingMark;
			this.datefirstArrestDate = datefirstArrestDate;
			this.arrestedPS = arrestedPS;
		}

		public int getCriminal_id() {
			return criminal_id;
		}

		public void setCriminal_id(int criminal_id) {
			this.criminal_id = criminal_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getIdentifyingMark() {
			return identifyingMark;
		}

		public void setIdentifyingMark(String identifyingMark) {
			this.identifyingMark = identifyingMark;
		}

		public Date getDatefirstArrestDate() {
			return datefirstArrestDate;
		}

		public void setDatefirstArrestDate(Date datefirstArrestDate) {
			this.datefirstArrestDate = datefirstArrestDate;
		}

		public String getArrestedPS() {
			return arrestedPS;
		}

		public void setArrestedPS(String arrestedPS) {
			this.arrestedPS = arrestedPS;
		}

		@Override
		public String toString() {
			return "Criminal id = " + criminal_id + ", Name = " + name + ", Date of Birth = " + dob + ", Gender = "
					+ gender + ", Identifying Mark = " + identifyingMark + ", Date of first Arrest = " + datefirstArrestDate
					+ ", Arrested from polise station = " + arrestedPS;
		}
		
		
}
