package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.realesates.Apartment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class ApartmentRowMapper implements RowMapper<Apartment> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(rs.getInt("id"));
        apartment.setAddress(rs.getString("address"));
        apartment.setPrice(rs.getDouble("price"));
        apartment.setDescription(rs.getString("description"));
        apartment.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
        apartment.setApartmentType(rs.getString("apartment_Type"));
        apartment.setRealEstateType(rs.getString("REAL_ESTATE_TYPE"));
        apartment.setBuildMaterial("build_Material");
        apartment.setSold(rs.getBoolean("sold"));
        apartment.getSeller().setId(rs.getInt("seller_id"));
        apartment.getEmployee().setId(rs.getInt("employee_id"));
        return apartment;
    }
}