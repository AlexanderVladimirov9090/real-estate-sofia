package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.models.realesates.Apartment;
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
     * This class is used to Map Data to The objects fields.
     */
    class ApartmentRowMapper implements RowMapper<Apartment> {
        /**
         * Maps data to Object
         *
         * @param rs     is used to store all data from database and then extracted to the object`s fields.
         * @param rowNum Store what number of a row are we in.
         * @return Object from given class.
         * @throws SQLException
         */
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
            apartment.setSold(rs.getBoolean("sold"));
            apartment.getSeller().setId(rs.getInt("seller_id"));
            apartment.getEmployee().setId(rs.getInt("employee_id"));
            return apartment;
        }
    }

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

    public Apartment findTopByOrderByIdDesc(){
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
     * @param apartment
     * @return
     */
    public int insert(Apartment apartment) {
        return jdbcTemplate.update("INSERT INTO Apartment (ID, APARTMENT_TYPE, BUILD_MATERIAL) " + "VALUES((SELECT id FROM Property WHERE Property.id=?), ?, ?)",
                apartment.getId(), apartment.getApartmentType(), apartment.getBuildMaterial());

    }
//TODO update(Apartment apartment)
}
