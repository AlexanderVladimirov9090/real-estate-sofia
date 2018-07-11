package com.gmail.alexander.realestatesofia.repository;

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
    private JdbcTemplate jdbcTemplate;

    class ApartmentRowMapper implements RowMapper<Apartment> {

        @Override
        public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Apartment apartment = new Apartment();
            apartment.setId(rs.getInt("id"));
            apartment.setAddress(rs.getString("address"));
            apartment.setPrice(rs.getDouble("price"));
            apartment.setDescription(rs.getString("description"));
            apartment.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
            apartment.setApartmentType(rs.getString("apartment_Type"));
            apartment.setRealEstateType(rs.getString("REAL_ESTATE_TYPE"));
            apartment.setBuildMaterial("build_Material");
            apartment.setSold(rs.getBoolean("is_sold"));
            apartment.getSeller().setId(rs.getInt("seller_id"));
            apartment.getEmployee().setId(rs.getInt("employee_id"));
            return apartment;
        }
    }

    public List<Apartment> findAll() {
        return jdbcTemplate.query("SELECT Apartment.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, apartment_type, build_Material, is_sold, employee_id, seller_id FROM Apartment INNER JOIN Property ON Apartment.ID=Property.ID ORDER BY PRICE DESC", new ApartmentRowMapper());

    }

    public Apartment findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Apartment.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, apartment_type, build_Material FROM Apartment INNER JOIN Property ON Apartment.ID=Property.ID WHERE Property.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Apartment>(Apartment.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    public int insert(Apartment apartment) {
        return jdbcTemplate.update("INSERT INTO Apartment (ID, APARTMENT_TYPE, BUILD_MATERIAL) " + "VALUES((SELECT id FROM Property WHERE id=?), ?, ?)",
                apartment.getId(), apartment.getApartmentType(), apartment.getBuildMaterial());

    }

    public int update(Apartment apartment) {
        return jdbcTemplate.update("UPDATE Apartment " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM Employee WHERE id=? )  " + "WHERE id=?",
                apartment.getAddress(),
                apartment.getDescription(),
                apartment.getPrice(),
                apartment.getRealEstateType(),
                apartment.getSizeOfRealEstate(),
                apartment.getApartmentType(),
                apartment.getBuildMaterial(),
                apartment.getEmployee().getId(),
                apartment.getId());

    }
}
