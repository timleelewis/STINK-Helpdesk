package com.stinkelectronics.helpdesk.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stinkelectronics.helpdesk.model.Profile;

public class ProfileRowMapper implements RowMapper<Profile>{
	
	@Override
	public Profile mapRow(ResultSet set, int rnum) throws SQLException{
		Profile profile = new Profile();
		
		profile.setUserID(set.getString("UserID"));
		profile.setFirstName(set.getString("FirstName"));
		profile.setLastName(set.getString("LastName"));
		
		profile.setPassword(set.getString("Password"));
		profile.setEmail(set.getString("Email"));
		
		profile.setRoleID(set.getInt("RoleID"));
		profile.setRepairID(set.getInt("RepairID"));
		
		return profile;
	}
	
}
