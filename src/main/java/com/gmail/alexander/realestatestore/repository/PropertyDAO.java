package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.abstracts.Property;
import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.repository.rowmappers.PropertyRowMapper;
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
public class PropertyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Finds all Records of Property
     *
     * @return
     */
    public List<Property> findAll() {
        return jdbcTemplate.query("SELECT * FROM Property ORDER BY PRICE DESC", new PropertyRowMapper());

    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Property findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Property WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Property>(Property.class));
    }

    /**
     * Fetching last recoded data.
     *
     * @return
     */
    public Agency findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT * FROM Property ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Agency>(Agency.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Property WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param property
     * @return
     */
    public int insert(Property property) {
        return jdbcTemplate.update("INSERT INTO Property (address, description, sold ,price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, employee_id, seller_id) " + "VALUES(?, ?, ?, ?, ?, ?, (SELECT EMPLOYEE_ID FROM Seller WHERE id=?), (SELECT ID FROM Seller WHERE id=?) )",
                property.getAddress(), property.getDescription(), property.getSold(), property.getPrice(), property.getRealEstateType(), property.getSizeOfRealEstate(), property.getSeller().getId(), property.getSeller().getId());
    }

    /**
     * Updates record from database by id.
     *
     * @param property updated version of the record.
     * @return confirmation code.
     */
    public int update(Property property) {
        return jdbcTemplate.update("UPDATE Apartment " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM Employee WHERE id=? ), seller_id=(SELECT id FROM Seller WHERE id=?)  " + "WHERE id=?",
                property.getAddress(),
                property.getDescription(),
                property.getPrice(),
                property.getRealEstateType(),
                property.getSizeOfRealEstate(),
                property.getEmployee().getId(),
                property.getSeller().getId(),
                property.getId());

    }

}
