package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class AgencyRowMapper implements RowMapper<Agency> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
        Agency agency = new Agency();
        agency.setId(rs.getInt("id"));
        agency.setName(rs.getString("name"));
        agency.setAddress("address");
        agency.setPhone("phone");
        return agency;
    }
}