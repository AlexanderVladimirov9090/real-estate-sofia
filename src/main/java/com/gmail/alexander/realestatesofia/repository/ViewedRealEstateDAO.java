package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.concrete.ViewedRealEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 07.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class ViewedRealEstateDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    class ViewedRealEstateRowMapper implements RowMapper<ViewedRealEstate> {

        @Override
        public ViewedRealEstate mapRow(ResultSet rs, int rowNum) throws SQLException {
            ViewedRealEstate viewedRealEstate = new ViewedRealEstate();
            viewedRealEstate.setId(rs.getInt("id"));
            viewedRealEstate.setRealEstateViewingDate(rs.getTimestamp("date_of_view"));
            return viewedRealEstate;
        }
    }

    public List<ViewedRealEstate> findAll() {
        return jdbcTemplate.query("SELECT * FROM Viewed_Real_Estate", new ViewedRealEstateRowMapper());

    }

    public ViewedRealEstate findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Viewed_Real_Estate WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<ViewedRealEstate>(ViewedRealEstate.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Viewed_Real_Estate WHERE id=?", id);
    }

    public int insert(ViewedRealEstate viewedRealEstate) {
        return jdbcTemplate.update("INSERT INTO Viewed_Real_Estate (ID, property_id, buyer_id, date_of_view) " + "VALUES(?, (SELECT id FROM Property WHERE id=?),(SELECT id FROM Buyer WHERE id=?), ?)",
                viewedRealEstate.getId(), viewedRealEstate.getPropertyForView().getId(), viewedRealEstate.getBuyers().getId(), new Date(viewedRealEstate.getRealEstateViewingDate().getTime()));
    }


    public int update(ViewedRealEstate viewedRealEstate) {
        return jdbcTemplate.update("UPDATE House " + "SET property_id=(SELECT id FROM Property WHERE id=? ) , buyer_id=(SELECT id FROM Buyer WHERE id=? ) , date_of_view=? " + "WHERE id=?",
                viewedRealEstate.getPropertyForView().getId(), viewedRealEstate.getBuyers().getId(), viewedRealEstate.getRealEstateViewingDate(), viewedRealEstate.getId());

    }

}
