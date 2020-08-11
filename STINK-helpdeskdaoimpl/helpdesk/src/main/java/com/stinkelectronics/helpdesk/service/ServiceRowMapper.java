package com.stinkelectronics.helpdesk.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stinkelectronics.helpdesk.model.Service;

public class ServiceRowMapper implements RowMapper<Service> {

	@Override
	public Service mapRow(ResultSet a, int rowA) throws SQLException {
		Service srvc = new Service();
		srvc.setServiceID(a.getInt("ServiceID"));
		srvc.setServiceType(a.getString("ServiceType"));
		return srvc;
	}
	
}
