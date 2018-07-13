package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
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
 * This is the Repository of the Agency
 * Queries to the database for the Table Agency are made from here.
 */
//This annotation is to indicate the framework that this is repository and it will be used for database queries.
@Repository
public class AgencyDAO {
    //This annotation is used to indicate that it will using JDBC drivers.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * This class is used to Map Data to The objects fields.
     */
    class AgencyRowMapper implements RowMapper<Agency> {
        /**
         * Maps data to Object
         *
         * @param rs     is used to store all data from database and then extracted to the object`s fields.
         * @param rowNum Store what number of a row are we in.
         * @return Object from given class.
         * @throws SQLException
         */
        @Override
        public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
            Agency agency = new Agency();
            agency.setId(rs.getInt("id"));
            agency.setName(rs.getString("name"));
            agency.setAddress("address");
            agency.setPhone("phone");

            return agency;
        }
    }

    /**
     * Finds all Records of Agency
     *
     * @return
     */
    public List<Agency> findAll() {
        return jdbcTemplate.query("SELECT * FROM Agency", new AgencyRowMapper());
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Agency findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Agency WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Agency>(Agency.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Agency WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param agency
     * @return
     */
    public int insert(Agency agency) {
        return jdbcTemplate.update("INSERT INTO Agency ( name, address, Phone) " + "VALUES(  ?, ?, ?)",
                agency.getName(), agency.getAddress(), agency.getPhone());
    }

    /**
     * Updates record from database by id.
     *
     * @param agency updated version of the record.
     * @return confirmation code.
     */
    public int update(Agency agency) {
        return jdbcTemplate.update("UPDATE Agency " + "SET name=?, address=?, Phone=?  " + "WHERE id=?",
                agency.getName(), agency.getAddress(), agency.getPhone(), agency.getId());
    }
}
