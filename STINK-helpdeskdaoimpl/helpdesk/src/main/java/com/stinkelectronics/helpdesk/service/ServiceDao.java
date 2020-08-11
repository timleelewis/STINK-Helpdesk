package com.stinkelectronics.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Service;

@Configuration
@Repository
public class ServiceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Service getServicebyServiceID(int ServiceID) {
		try {
			String a = "SELECT * FROM account WHERE ServiceID =?";
				return jdbcTemplate.queryForObject(a, new Object[] {ServiceID}, new ServiceRowMapper()); 
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Service();
		}
	}
	
	public Service getServicebyServiceType(String ServiceType) {
		try {
			String b = "SELECT * FROM account WHERE ServiceID =?";
				return jdbcTemplate.queryForObject(b, new Object[] {ServiceType}, new ServiceRowMapper()); 
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Service();
		}
	}
	
}
