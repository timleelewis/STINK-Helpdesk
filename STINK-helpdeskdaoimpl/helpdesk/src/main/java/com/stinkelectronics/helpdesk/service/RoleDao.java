package com.stinkelectronics.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Role;

@Repository
@Configuration
public class RoleDao {
	@Autowired
	private JdbcTemplate jtemp;
	
	//query by User ID (Unique)
	public Role getRoleByUserID(int rid) {
		Role role = new Role();
		try {
			String query = "SELECT * FROM Role WHERE RoleID=?";
			return jtemp.queryForObject(query, new Object[]{rid}, new RoleRowMapper());
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return role;
		}
	}
}
