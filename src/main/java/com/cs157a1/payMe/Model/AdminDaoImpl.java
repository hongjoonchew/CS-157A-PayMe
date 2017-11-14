package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Admin;


@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao  {

	@Override
	public Collection<Admin> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin returnAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdminToDB(Admin Admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String returnPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int returnauthoritykey(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAdmin(Admin Admin) {
		// TODO Auto-generated method stub
		
	}

}
