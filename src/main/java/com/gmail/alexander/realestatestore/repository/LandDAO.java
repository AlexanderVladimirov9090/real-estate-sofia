package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.realesates.Land;
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
     * This class is used to Map Data to The objects fields.
     */
    class LandRowMapper implements RowMapper<Land> {
        /**
         * Maps data to Object
         *
         * @param rs     is used to store all data from database and then extracted to the object`s fields.
         * @param rowNum Store what number of a row are we in.
         * @return Object from given class.
         * @throws SQLException
         */
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
            land.setSold(rs.getBoolean("sold"));
            land.getSeller().setId(rs.getInt("seller_id"));
            land.getEmployee().setId(rs.getInt("employee_id"));
            return land;
        }
    }

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

    public Agency findTopByOrderByIdDesc(){
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
     * @param land
     * @return
     */

    public int insert(Land land) {
        return jdbcTemplate.update("INSERT INTO Land (ID, is_regulated, land_type) " + "VALUES((SELECT id FROM Property WHERE id=?), ?, ?)",
                land.getId(), land.isRegulated(), land.getLandType());

    }
    //TODO update(Land land)
}
