package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.realesates.Land;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class LandRowMapper implements RowMapper<Land> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Land mapRow(ResultSet rs, int rowNum) throws SQLException {
        Land land = new Land();
        land.setId(rs.getInt("id"));
        land.setAddress(rs.getString("address"));
        land.setDescription(rs.getString("description"));
        land.setPrice(rs.getDouble("price"));
        land.setSizeOfRealEstate(rs.getInt("size_of_real_estate"));
        land.setRealEstateType(rs.getString("real_estate_type"));
        land.setLandType(rs.getString("land_type"));
        land.setRegulated(rs.getBoolean("is_regulated"));
        land.setSold(rs.getBoolean("sold"));
        land.getSeller().setId(rs.getInt("seller_id"));
        land.getEmployee().setId(rs.getInt("employee_id"));
        return land;
    }
}