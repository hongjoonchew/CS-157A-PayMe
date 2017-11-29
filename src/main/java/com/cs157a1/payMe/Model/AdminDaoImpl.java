package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Admin;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Model.MySqlDao.AccountsRowMapper;


@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static class AdminsRowMapper implements RowMapper<Admin>{

		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			admin.setUsername(rs.getString("username"));
			admin.setAuthorities(rs.getInt("authorities"));
			return admin;
		}
	}
	
	@Override
	public Collection<Admin> returnAllInfo() {
		final String sql = "SELECT username, authorities FROM AccessControl";
		Collection<Admin> admins = jdbcTemplate.query(sql, new AdminsRowMapper());
		return admins;
	}

	@Override
	public Admin returnAdminByUsername(String username) {
		final String sql = "SELECT username, authorities FROM Users where username = ?";
		Admin admin = jdbcTemplate.queryForObject(sql, new AdminsRowMapper(), username);
		return admin;
	}

	@Override
	public void addAdminToDB(Admin admin) {
		final String acountsql = "INSERT INTO Accounts (username, password, first_name, last_name, email, enabled) VALUES (?,?,?,?,?,?)";
		final String accessSQL = "INSERT INTO AccessControl(username, authorities) VALUES (?,?)";
		
		String username = admin.getUsername();
		String first_name = admin.getFirstName();
		String last_name = admin.getLastName();
		String password = admin.getPassword();
		String email = admin.getEmail();
		int enabled = 1;
		
		jdbcTemplate.update(acountsql,new Object[] {username, password, first_name, last_name, email, enabled});
		jdbcTemplate.update(accessSQL, new Object[] {username,1});	
	}

	@Override
	public void deleteAdmin(String username) {
		final String sql_admin = "DELETE FROM AccessControl WHERE username = ?";
		final String sql_accont = "DELETE FROM Accounts WHERE username = ?";
		
		jdbcTemplate.update(sql_accont,username);
		jdbcTemplate.update(sql_admin,username);
		
	}

	@Override
	public String returnPassword(String username) {
		final String sql = "SELECT username, password FROM Accounts WHERE username = ?";
		Account account = jdbcTemplate.queryForObject(sql, new AccountsRowMapper(), username);
		return account.getPassword();
	}

	@Override
	public int returnauthoritykey(String username) {
		final String sql = "SELECT username, authorities FROM AccessControl WHERE username = ?";
		Admin admin = jdbcTemplate.queryForObject(sql, new AdminsRowMapper(), username);
		return admin.getAuthorities();
	}

	@Override
	public void updateAdmin(Admin admin) {
		// todo
		// update account
		final String sql = "UPDATE AccessControl SET authorities = ? WHERE username = ?";
		String username = admin.getUsername();
		int accesscontrol = admin.getAuthorities();
		jdbcTemplate.update(sql, new Object[] {accesscontrol, username});	
	}

}
