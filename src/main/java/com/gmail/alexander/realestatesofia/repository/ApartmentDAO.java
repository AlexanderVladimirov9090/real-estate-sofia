package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.concrete.RealEstateEmployee;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
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
    RealEstateEmployeeDAO realEstateEmployeeDAO;
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ApartmentRowMapper implements RowMapper<Apartment> {

        @Override
        public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Apartment property = new Apartment();
            property.setAddress(rs.getString("address"));
            property.setPrice(rs.getInt("price"));
            property.setDescription(rs.getString("description"));
            property.setSizeOfRealEstate(rs.getInt("sizeOfRealEstate"));
            property.setApartmentType(rs.getString("apartment_Type"));
            property.setBuildMaterial("build_Material");
            /*
                TODO implement CRUD Logic to REALESTATEEMPLOYEE
            property.setRealEstateEmployee();*/
            return property;
        }
    }

    public List<Apartment> findAll() {
        return jdbcTemplate.query("SELECT * FROM Apartment", new ApartmentRowMapper());

    }

    public Apartment findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Apartment WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Apartment>(Apartment.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    public int insert(Apartment apartment) {

        return jdbcTemplate.update("INSERT INTO Apartment (id, address, description, price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, apartment_Type, build_Material, employee_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?,  (SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=?    ))",
                apartment.getId(), apartment.getAddress(), apartment.getDescription(), apartment.getPrice(), apartment.getRealEstateType(), apartment.getSizeOfRealEstate(), apartment.getApartmentType(), apartment.getBuildMaterial(), apartment.getRealEstateEmployee().getId());

    }

    public int update(Apartment apartment) {
        return jdbcTemplate.update("UPDATE Apartment " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=? )  " + "WHERE id=?",
                apartment.getAddress(),
                apartment.getDescription(),
                apartment.getPrice(),
                apartment.getRealEstateType(),
                apartment.getSizeOfRealEstate(),
                apartment.getApartmentType(),
                apartment.getBuildMaterial(),
                apartment.getRealEstateEmployee().getId(),
                apartment.getId());

    }
}