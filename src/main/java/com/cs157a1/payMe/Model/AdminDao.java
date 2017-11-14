package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.Admin;

public interface AdminDao {
Collection<Admin> returnAllInfo();
	
	Admin returnAdminByUsername(String username);
	
	void addAdminToDB(Admin Admin);
	
	void deleteAdmin(String username);
	
	String returnPassword(String username);
	
	int returnauthoritykey(String username); 

	void updateAdmin(Admin Admin);

}
