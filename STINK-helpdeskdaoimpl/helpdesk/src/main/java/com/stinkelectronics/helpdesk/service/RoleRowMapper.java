package com.stinkelectronics.helpdesk.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stinkelectronics.helpdesk.model.Role;

public class RoleRowMapper implements RowMapper<Role>{
	@Override
	public Role mapRow(ResultSet set, int rnum) throws SQLException{
		Role role = new Role();
		
		role.setRoleID(set.getInt("RoleID"));
		role.setJob(set.getString("Job"));
		
		return role;
	}
}
