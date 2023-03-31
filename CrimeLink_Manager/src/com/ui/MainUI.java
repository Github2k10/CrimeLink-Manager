package com.ui;

import java.sql.Date;

import com.dao.CrimeDao;
import com.dao.CrimeDaoImp;
import com.dto.CrimeDto;
import com.dto.CrimeDtoImp;

public class MainUI {

	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImp();
		
		dao.deleteCrime(3);
	}

}
