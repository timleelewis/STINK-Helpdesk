package com.stinkelectronics.helpdesk.service;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import com.stinkelectronics.helpdesk.model.Repair;

public class RepairRowMapper implements RowMapper<Repair> {

    @Override
    public Repair mapRow(ResultSet rs, int rNum) throws SQLException {

        Repair r = new Repair();
        r.setEName(rs.getString("EName"));
        r.setStatus(rs.getString("Status"));
        r.setServiceID(rs.getInt("ServiceID"));
        return r;
    }
}
