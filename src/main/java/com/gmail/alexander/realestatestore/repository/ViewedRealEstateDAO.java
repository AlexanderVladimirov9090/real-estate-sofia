package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.concrete.ViewedRealEstate;
import com.gmail.alexander.realestatestore.repository.rowmappers.ViewedRealEstateRowMapper;
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
 * This is the Repository of viewed by the buyer properties.
 */
//Tell the framework that this is repository.
@Repository
public class ViewedRealEstateDAO {
    //This class uses JDBC for writing native queries.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Finds all Records of ViewedRealEstate
     *
     * @return collection of viewed by buyer properties.
     */
    public List<ViewedRealEstate> findAll() {
        return jdbcTemplate.query("SELECT * FROM Viewed_Real_Estate", new ViewedRealEstateRowMapper());

    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return object from given class
     */
    public ViewedRealEstate findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Viewed_Real_Estate WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<ViewedRealEstate>(ViewedRealEstate.class));
    }

    /**
     * Fetching last recoded data.
     *
     * @return
     */
    public Agency findTopByOrderByIdDesc(){
        return jdbcTemplate.queryForObject("SELECT * FROM Viewed_Real_Estate ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Agency>(Agency.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return confirmation code.
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Viewed_Real_Estate WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param viewedRealEstate view by the Buyer real estate.
     * @return confirmation code.
     */
    public int insert(ViewedRealEstate viewedRealEstate) {

        return jdbcTemplate.update("INSERT INTO Viewed_Real_Estate (property_id, buyer_id, date_of_view) " + "VALUES((SELECT id FROM Property WHERE id=?),(SELECT id FROM Buyer WHERE id=?), ?)",
                viewedRealEstate.getPropertyForView().getId(), viewedRealEstate.getBuyer().getId(), new Date(viewedRealEstate.getRealEstateViewingDate().getTime()));
    }

    /**
     * Updates record from database by id.
     * @param viewedRealEstate updated version of the record.
     * @return confirmation code.
     */
    public int update(ViewedRealEstate viewedRealEstate) {
        return jdbcTemplate.update("UPDATE House " + "SET property_id=(SELECT id FROM Property WHERE id=? ) , buyer_id=(SELECT id FROM Buyer WHERE id=? ) , date_of_view=? " + "WHERE id=?",
                viewedRealEstate.getPropertyForView().getId(), viewedRealEstate.getBuyer().getId(), viewedRealEstate.getRealEstateViewingDate(), viewedRealEstate.getId());

    }

}
