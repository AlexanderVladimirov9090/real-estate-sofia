package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
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
public class PropertyDAO {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PropertyRowMapper implements RowMapper<Property> {

        @Override
        public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
            Property property = new Property();
            property.setAddress(rs.getString("address"));
            property.setPrice(rs.getDouble("price"));
            property.setDescription(rs.getString("description"));
            property.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
            Employee employee = employeeDAO.findById(rs.getInt("employee_id"));
            property.setEmployee(employee);
            return property;
        }
    }

    public List<Property> findAll() {
        return jdbcTemplate.query("SELECT * FROM Property ORDER BY PRICE DESC", new PropertyRowMapper());

    }

    public Property findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Property WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Property>(Property.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Property WHERE id=?", id);
    }

    public int insert(Property property) {
        int countOfEmployee = employeeDAO.countEmployees();
        return jdbcTemplate.update("INSERT INTO Property (id, address, description, price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, employee_id, seller_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, (SELECT id FROM Employee WHERE id=?), (SELECT id FROM Seller WHERE id=?) )",
                property.getId(), property.getAddress(), property.getDescription(), property.getPrice(), property.getRealEstateType(), property.getSizeOfRealEstate(), randomEmployee(countOfEmployee), property.getSeller().getId());
    }

    public int update(Property property) {
        return jdbcTemplate.update("UPDATE Apartment " + "SET ADDRESS=?, DESCRIPTION=?, PRICE=?, REAL_ESTATE_TYPE=?, SIZE_OF_REAL_ESTATE=?, APARTMENT_TYPE=?, BUILD_MATERIAL=?, EMPLOYEE_ID=(SELECT id FROM Employee WHERE id=? ), seller_id=(SELECT id FROM Seller WHERE id=?)  " + "WHERE id=?",
                property.getAddress(),
                property.getDescription(),
                property.getPrice(),
                property.getRealEstateType(),
                property.getSizeOfRealEstate(),
                property.getEmployee().getId(),
                property.getSeller().getId(),
                property.getId());

    }

    private int randomEmployee(int countOfEmployees) {
        Random r = new Random();
        return r.nextInt((countOfEmployees - 1) + 1) + 1;
    }

}
