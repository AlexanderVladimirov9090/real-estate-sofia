package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
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
public class BuyerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class BuyerRowMapper implements RowMapper<Buyer> {

        @Override

        public Buyer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setId(rs.getInt("id"));
        buyer.setName(rs.getString("name"));
        buyer.setPhone(rs.getString("phone"));
        buyer.setBudget(rs.getDouble("budget"));
        return buyer;
        }
    }

    public List<Buyer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Buyer ", new BuyerRowMapper());

    }

    public Buyer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Apartment WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Buyer>(Buyer.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    public int insert(Buyer buyer) {
/*

        return jdbcTemplate.update("INSERT INTO Apartment (id, address, description, price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, apartment_Type, build_Material, employee_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?,  (SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=?    ))",
                apartment.getId(), apartment.getAddress(), apartment.getDescription(), apartment.getPrice(), apartment.getRealEstateType(), apartment.getSizeOfRealEstate(), apartment.getApartmentType(), apartment.getBuildMaterial(), apartment.getEmployee().getId());
*/
        return 0;
    }

    public int update(Buyer buyer) {
        /*return jdbcTemplate.update("UPDATE Apartment " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=? )  " + "WHERE id=?",
                apartment.getAddress(),
                apartment.getDescription(),
                apartment.getPrice(),
                apartment.getRealEstateType(),
                apartment.getSizeOfRealEstate(),
                apartment.getApartmentType(),
                apartment.getBuildMaterial(),
                apartment.getEmployee().getId(),
                apartment.getId());
*/
        return 0;
    }
}
