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
 */
@Repository
public class AgencyDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class AgencyRowMapper implements RowMapper<Agency> {

        @Override
        public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
            Agency agency = new Agency();
            agency.setId(rs.getLong("id"));
            agency.setName(rs.getString("name"));
            agency.setAddress("address");
            agency.setContactByPhone("contactByPhone");

            return agency;
        }
    }

    public List<Agency> findAll() {
        return jdbcTemplate.query("SELECT * FROM Agency", new AgencyRowMapper());
    }

    public Agency findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Agency WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Agency>(Agency.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Agency WHERE id=?", new Object[]{id});
    }

    public int insert(Agency agency) {
        return jdbcTemplate.update("INSERT INTO Agency (id, name, address, contact_By_Phone) " + "VALUES(?, ?, ?, ?)",
                agency.getId(), agency.getName(), agency.getAddress(), agency.getContactByPhone());
    }

    public int update(Agency agency) {
        return jdbcTemplate.update("UPDATE Agency " + "SET name=?, address=?, contact_By_Phone=?  " + "WHERE id=?",
                new Object[]{agency.getName(), agency.getAddress(), agency.getContactByPhone(), agency.getId()});
    }
}
