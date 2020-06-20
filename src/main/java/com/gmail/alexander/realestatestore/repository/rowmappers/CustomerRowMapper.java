package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.abstracts.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class CustomerRowMapper implements RowMapper<Customer> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setPhone(rs.getString("phone"));
        customer.setName(rs.getString("name"));
        return customer;
    }
}