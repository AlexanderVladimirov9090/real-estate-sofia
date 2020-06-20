package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.costumers.Seller;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class SellerRowMapper implements RowMapper<Seller> {

    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("id"));
        seller.setName(rs.getString("name"));
        seller.setPhone(rs.getString("phone"));
        return seller;
    }
}