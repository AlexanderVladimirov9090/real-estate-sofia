package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.realesates.House;
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
public class HouseDAO {
    @Autowired
    private final EmployeeDAO employeeDAO;
    @Autowired
    private final SellerDAO sellerDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HouseDAO(EmployeeDAO employeeDAO, SellerDAO sellerDAO) {
        this.employeeDAO = employeeDAO;
        this.sellerDAO = sellerDAO;
    }

    class HouseRowMapper implements RowMapper<House> {

        @Override
        public House mapRow(ResultSet rs, int rowNum) throws SQLException {
            House house = new House();
            house.setAddress(rs.getString("address"));
            house.setPrice(rs.getDouble("price"));
            house.setDescription(rs.getString("description"));
            house.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
            house.setRealEstateType(rs.getString("REAL_ESTATE_TYPE"));
            house.setHouseType(rs.getString("house_type"));
            house.setBuildMaterial("build_Material");
            house.setParkingSpace(rs.getInt("parking_space"));
            house.setYardSize(rs.getInt("yard_size"));
            house.getSeller().setId(rs.getInt("seller_id"));
            house.getEmployee().setId(rs.getInt("employee_id"));
            return house;
        }
    }

    public List<House> findAll() {
        return jdbcTemplate.query("SELECT House.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, house_type, build_Material, parking_space, yard_size, seller_id, employee_id FROM House INNER JOIN Property ON House.ID=Property.ID ORDER BY PRICE DESC", new HouseRowMapper());

    }

    public House findById(int id) {
        return jdbcTemplate.queryForObject("SELECT House.id, address, price, description, SIZE_OF_REAL_ESTATE, REAL_ESTATE_TYPE, house_type, build_Material, parking_space, yard_size, seller_id, employee_id FROM House INNER JOIN Property ON House.ID=Property.ID WHERE Property.ID=?", new Object[]{id}, new BeanPropertyRowMapper<House>(House.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM House WHERE id=?", id);
    }

    public int insert(House house) {
        return jdbcTemplate.update("INSERT INTO HOUSE (ID, BUILD_MATERIAL, HOUSE_TYPE, PARKING_SPACE, YARD_SIZE) " + "VALUES((SELECT id FROM Property WHERE id=?), ?, ?, ?, ?)",
                house.getId(), house.getBuildMaterial(), house.getHouseType(), house.getParkingSpace(), house.getYardSize());

    }


    public int update(House house) {
        return jdbcTemplate.update("UPDATE House " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM Employee WHERE id=? )  " + "WHERE id=?",
                house.getAddress(),
                house.getDescription(),
                house.getPrice(),
                house.getRealEstateType(),
                house.getSizeOfRealEstate(),
                house.getHouseType(),
                house.getBuildMaterial(),
                house.getEmployee().getId(),
                house.getId());

    }

}