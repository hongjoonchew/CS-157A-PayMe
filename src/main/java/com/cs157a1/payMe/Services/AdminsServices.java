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
	
    Collection<Admin> returnAllInfo(){
    	 return adminDao.returnAllInfo();
    }
	
	Admin returnAdminByUsername(String username) {
		return adminDao.returnAdminByUsername(username);
	}
	
	void addAdminToDB(Admin Admin) {
		adminDao.addAdminToDB(Admin);
	}
	
	void deleteAdmin(String username) {
		adminDao.deleteAdmin(username);
	}
	
	String returnPassword(String username) {
		return adminDao.returnPassword(username);
	}
	
	int returnauthoritykey(String username) {
		return adminDao.returnauthoritykey(username);
	}

	void updateAdmin(Admin Admin) {
		adminDao.updateAdmin(Admin);
	}

}
