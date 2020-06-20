package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.abstracts.Property;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class PropertyRowMapper implements RowMapper<Property> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
        Property property = new Property();
        property.setAddress(rs.getString("address"));
        property.setPrice(rs.getDouble("price"));
        property.setDescription(rs.getString("description"));
        property.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
        property.getSeller().setId(rs.getInt("seller_id"));
        property.getEmployee().setId(rs.getInt("employee_id"));
        property.setSold(rs.getBoolean("sold"));
        return property;
    }
}
