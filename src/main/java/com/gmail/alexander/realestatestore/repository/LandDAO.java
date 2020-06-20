package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.realesates.Land;
import com.gmail.alexander.realestatestore.repository.rowmappers.LandRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 08.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class LandDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Finds all Records of Agency
     *
     * @return
     */

    public List<Land> findAll() {
        return jdbcTemplate.query("SELECT Land.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, land_type, sold, is_regulated, seller_id, employee_id FROM Land INNER JOIN Property ON Land.ID=Property.ID ORDER BY PRICE DESC", new LandRowMapper());

    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Land findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Land.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, land_type, is_sold, is_regulated, seller_id, employee_id FROM Land INNER JOIN Property ON Land.ID=Property.ID WHERE Property.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Land>(Land.class));
    }

    public Agency findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT Land.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, land_type, is_sold, is_regulated, seller_id, employee_id FROM Land INNER JOIN Property ON Land.ID=Property.ID ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Agency>(Agency.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param land
     * @return
     */

    public int insert(Land land) {
        return jdbcTemplate.update("INSERT INTO Land (ID, is_regulated, land_type) " + "VALUES((SELECT id FROM Property WHERE id=?), ?, ?)",
                land.getId(), land.isRegulated(), land.getLandType());

    }
    //TODO update(Land land)
}
