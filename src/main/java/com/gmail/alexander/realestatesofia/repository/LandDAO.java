package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.realesates.Land;
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

    //TODO Register Apartment  copy modify Apartment`s logic for this one.


    @Autowired
    private JdbcTemplate jdbcTemplate;

    class LandRowMapper implements RowMapper<Land> {

        @Override
        public Land mapRow(ResultSet rs, int rowNum) throws SQLException {
            Land land = new Land();
            land.setId(rs.getInt("id"));
            land.setAddress(rs.getString("address"));
            land.setDescription(rs.getString("description"));
            land.setPrice(rs.getDouble("price"));
            land.setSizeOfRealEstate(rs.getInt("size_of_real_estate"));
            land.setRealEstateType(rs.getString("real_estate_type"));
            land.setLandType(rs.getString("land_type"));
            land.setRegulated(rs.getBoolean("is_regulated"));
            land.setSold(rs.getBoolean("is_sold"));
            land.getSeller().setId(rs.getInt("seller_id"));
            land.getEmployee().setId(rs.getInt("employee_id"));
            return land;
        }
    }

    public List<Land> findAll() {
        return jdbcTemplate.query("SELECT Land.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, land_type, is_sold, is_regulated, seller_id, employee_id FROM Land INNER JOIN Property ON Land.ID=Property.ID ORDER BY PRICE DESC", new LandRowMapper());

    }

    public Land findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Land.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, land_type, is_sold, is_regulated, seller_id, employee_id FROM Land INNER JOIN Property ON Land.ID=Property.ID WHERE Property.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Land>(Land.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    public int insert(Land land) {
        return jdbcTemplate.update("INSERT INTO Land (ID, is_regulated, land_type) " + "VALUES((SELECT id FROM Property WHERE id=?), ?, ?)",
                land.getId(), land.isRegulated(), land.getLandType());

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
