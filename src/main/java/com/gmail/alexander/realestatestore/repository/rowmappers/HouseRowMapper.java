package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.realesates.House;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class HouseRowMapper implements RowMapper<House> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public House mapRow(ResultSet rs, int rowNum) throws SQLException {
        House house = new House();
        house.setAddress(rs.getString("address"));
        house.setPrice(rs.getDouble("price"));
        house.setDescription(rs.getString("description"));
        house.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
        house.setRealEstateType(rs.getString("REAL_ESTATE_TYPE"));
        house.setHouseType(rs.getString("house_type"));
        house.setBuildMaterial("build_Material");
        house.setParkingSpace(rs.getInt("parking_space"));
        house.setYardSize(rs.getInt("yard_size"));
        house.getSeller().setId(rs.getInt("seller_id"));
        house.getEmployee().setId(rs.getInt("employee_id"));
        return house;
    }
}