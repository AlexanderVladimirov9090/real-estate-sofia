package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
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
 * Created on 07.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class ApartmentDAO {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class ApartmentRowMapper implements RowMapper<Apartment> {

        @Override
        public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Apartment property = new Apartment();
            property.setAddress(rs.getString("address"));
            property.setPrice(rs.getDouble("price"));
            property.setDescription(rs.getString("description"));
            property.setSizeOfRealEstate(rs.getInt("SIZE_OF_REAL_ESTATE"));
            property.setApartmentType(rs.getString("apartment_Type"));
            property.setBuildMaterial("build_Material");
            Employee employee = employeeDAO.findById(rs.getInt("employee_id"));
            property.setEmployee(employee);
            /*

ID  	ADDRESS  	DESCRIPTION  	PRICE  	REAL_ESTATE_TYPE  	SIZE_OF_REAL_ESTATE  	EMPLOYEE_ID  	APARTMENT_TYPE  	BUILD_MATERIAL
                TODO implement CRUD Logic to REALESTATEEMPLOYEE
            property.setEmployee();*/
            return property;
        }
    }

    public List<Apartment> findAll() {
        return jdbcTemplate.query("SELECT * FROM Apartment ORDER BY PRICE DESC", new ApartmentRowMapper());

    }

    public Apartment findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Apartment WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Apartment>(Apartment.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Apartment WHERE id=?", id);
    }

    public int insert(Apartment apartment) {
        int countOfEmployee = employeeDAO.countEmployees();
        return jdbcTemplate.update("INSERT INTO Apartment (id, address, description, price, REAL_ESTATE_TYPE, SIZE_OF_REAL_ESTATE, apartment_Type, build_Material, employee_id, seller_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, (SELECT id FROM Employee WHERE id=?), (SELECT id FROM Seller WHERE id=?) )",
                apartment.getId(), apartment.getAddress(), apartment.getDescription(), apartment.getPrice(), apartment.getRealEstateType(), apartment.getSizeOfRealEstate(), apartment.getApartmentType(), apartment.getBuildMaterial(), randomEmployee(countOfEmployee), apartment.getSeller().getId());

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

    private int randomEmployee(int countOfEmployees) {
        Random r = new Random();
        return r.nextInt((countOfEmployees - 1) + 1) + 1;
    }

}
