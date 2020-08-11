package com.stinkelectronics.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Repair;

@Configuration
@Repository
public class RepairDao {
    @Autowired
    private JdbcTemplate jtem;

    //Query for
    public Repair getRepairByRepairID(int RepairID) {
        Repair repair = new Repair();
        try {
            //String queryr = "SELECT * FROM Repair WHERE RepairID=?";
        	String query = "SELECT * FROM Repair WHERE RepairID='" + RepairID + "'";
        	List<Repair> repairs = jtem.query(query, new RepairRowMapper());
        	if(repairs.isEmpty()) {
        		System.out.println("No such record found");
        		return repair;
        	}
        	return repairs.get(0);
            //return jtem.queryForObject(queryr, new Object[]{RepairID}, new RepairRowMapper());
        } catch (DataAccessException re) {
            System.out.println(re.getMessage());
            return repair;
        }
    }
    /*Queries for RepairByUserID
    */
    
    public boolean addRepair(Repair repair) {
    	try {
    		String insert = "INSERT INTO Repair (Service, EName, Status) VALUES ('" + repair.getServiceID() + "', '" + repair.getEName() + "', '" + repair.getStatus() + "')";
    		jtem.execute(insert);
    		return true;
    	}
    	catch(DataAccessException e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
    
    public boolean removeRepair(int RepairID) {
    	
    	try {
    		String remove = "DELETE FROM Repair WHERE RepairID='" + RepairID+ "'";
    		jtem.execute(remove);
    		return true;
    	}
    	catch(DataAccessException e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
    
    public boolean updateRepairStatus(int RepairID, String Status) {
    	try {
    		String update = "UPDATE Repair " + 
    				"SET Status='"+ Status +"' " + 
    				"WHERE RepairID='" + RepairID + "'";
    		jtem.execute(update);
    		return true;
    	}
    	catch(DataAccessException e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
}
