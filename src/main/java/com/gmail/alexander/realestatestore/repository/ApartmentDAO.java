package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.realesates.Apartment;
import com.gmail.alexander.realestatestore.repository.rowmappers.ApartmentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
public class ApartmentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Finds all Records of Apartment
     *
     * @return
     */
    public List<Apartment> findAll() {
        return jdbcTemplate.query("SELECT Apartment.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, apartment_type, build_Material, sold, employee_id, seller_id FROM Apartment INNER JOIN Property ON Apartment.ID=Property.ID ORDER BY PRICE DESC", new ApartmentRowMapper());
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Apartment findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Apartment.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, apartment_type, build_Material FROM Apartment INNER JOIN Property ON Apartment.ID=Property.ID WHERE Property.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Apartment>(Apartment.class));
    }

    public Apartment findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT Apartment.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, apartment_type, build_Material FROM Apartment INNER JOIN Property ON Apartment.ID=Property.ID ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Apartment>(Apartment.class));
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
     * @param apartment
     * @return
     */
    public int insert(Apartment apartment) {
        return jdbcTemplate.update("INSERT INTO Apartment (ID, APARTMENT_TYPE, BUILD_MATERIAL) " + "VALUES((SELECT id FROM Property WHERE Property.id=?), ?, ?)", apartment.getId(), apartment.getApartmentType(), apartment.getBuildMaterial());

    }
//TODO update(Apartment apartment)
}
