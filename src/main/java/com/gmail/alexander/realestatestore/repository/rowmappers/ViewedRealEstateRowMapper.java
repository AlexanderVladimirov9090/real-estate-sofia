package com.gmail.alexander.realestatestore.repository.rowmappers;

import com.gmail.alexander.realestatestore.models.concrete.ViewedRealEstate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to Map Data to The objects fields.
 */
public class ViewedRealEstateRowMapper implements RowMapper<ViewedRealEstate> {
    /**
     * Maps data to Object
     *
     * @param rs     is used to store all data from database and then extracted to the object`s fields.
     * @param rowNum Store what number of a row are we in.
     * @return Object from given class.
     * @throws SQLException
     */
    @Override
    public ViewedRealEstate mapRow(ResultSet rs, int rowNum) throws SQLException {
        ViewedRealEstate viewedRealEstate = new ViewedRealEstate();
        viewedRealEstate.setId(rs.getInt("id"));
        viewedRealEstate.getBuyer().setId(rs.getInt("buyer_id"));
        viewedRealEstate.getPropertyForView().setId(rs.getInt("property_id  "));
        viewedRealEstate.setRealEstateViewingDate(rs.getTimestamp("date_of_view"));
        return viewedRealEstate;
    }
}