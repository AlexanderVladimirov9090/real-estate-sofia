package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.costumers.Buyer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class BuyerRowMapper implements RowMapper<Buyer> {

    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override

    public Buyer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setId(rs.getInt("id"));
        buyer.setName(rs.getString("name"));
        buyer.setPhone(rs.getString("phone"));
        buyer.setBudget(rs.getDouble("budget"));
        buyer.getEmployee().setId(rs.getInt("employee_id"));
        return buyer;
    }
}
