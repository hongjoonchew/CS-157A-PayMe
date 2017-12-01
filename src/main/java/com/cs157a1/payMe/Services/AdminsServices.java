package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.Admin;
import com.cs157a1.payMe.Model.AdminDao;

@Service
public class AdminsServices {
	
	@Autowired
	@Qualifier("AdminDao")
	private AdminDao adminDao;
	
    public Collection<Admin> returnAllInfo(){
    	 return adminDao.returnAllInfo();
    }
	
	public Admin returnAdminByUsername(String username) {
		return adminDao.returnAdminByUsername(username);
	}
	
	public void addAdminToDB(Admin Admin) {
		adminDao.addAdminToDB(Admin);
	}
	
	public void deleteAdmin(String username) {
		adminDao.deleteAdmin(username);
	}
	
	public String returnPassword(String username) {
		return adminDao.returnPassword(username);
	}
	
	public int returnauthoritykey(String username) {
		return adminDao.returnauthoritykey(username);
	}

	public void updateAdmin(Admin Admin) {
		adminDao.updateAdmin(Admin);
	}

}
