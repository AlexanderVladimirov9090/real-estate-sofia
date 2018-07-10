package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.realesates.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created on 08.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class HouseDAO {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class HouseRowMapper implements RowMapper<House> {

        @Override
        public House mapRow(ResultSet rs, int rowNum) throws SQLException {
            House property = new House();
            property.setAddress(rs.getString("address"));
            property.setPrice(rs.getDouble("price"));
            property.setDescription(rs.getString("description"));
            property.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
            property.setHouseType(rs.getString("house_type"));
            property.setBuildMaterial("build_Material");
            property.setParkingSpace(rs.getInt("parking_space"));
            property.setYardSize(rs.getInt("yard_size"));
            Employee employee = employeeDAO.findById(rs.getInt("employee_id"));
            property.setEmployee(employee);
            return property;
        }
    }
//TODO Register house  copy modify Apartment`s logic for this one.

    public List<House> findAll() {
        return jdbcTemplate.query("SELECT * FROM House ORDER BY PRICE DESC", new HouseRowMapper());

    }

    public House findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM House WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<House>(House.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM House WHERE id=?", id);
    }

    public int insert(House house) {
       /* return jdbcTemplate.update("INSERT INTO House (id, address, description, price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, apartment_Type, build_Material, employee_id, seller_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, (SELECT id FROM Employee WHERE id=?), (SELECT id FROM Seller WHERE id=?) )",
                apartment.getId(), apartment.getAddress(), apartment.getDescription(), apartment.getPrice(), apartment.getRealEstateType(), apartment.getSizeOfRealEstate(), apartment.getApartmentType(), apartment.getBuildMaterial(), randomEmployee(countOfEmployee), apartment.getSeller().getId());
      */  return 0;
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
    //TODO extract method.
    private int randomEmployee(int countOfEmployees) {
        Random r = new Random();
        return r.nextInt((countOfEmployees - 1) + 1) + 1;
    }
}
