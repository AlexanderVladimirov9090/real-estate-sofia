package com.gmail.alexander.realestatesofia.repository;

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
 * Created on 07.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName("name");
            employee.setPhone("phone");
            return employee;
        }
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM Employee", new EmployeeRowMapper());
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Employee WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Employee WHERE id=?", id);
    }

    public int insert(Employee employee) {

        return jdbcTemplate.update("INSERT INTO Employee (id, NAME, PHONE, agency_id) " + "VALUES(?, ?, ?, (SELECT id FROM AGENCY WHERE id=? ) )",
                employee.getId(), employee.getName(), employee.getPhone(), employee.getAgency().getId());

    }

    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE Employee" + "SET NAME=?, PHONE=?  " + "WHERE ID=?"
                , employee.getName(), employee.getPhone(), employee.getId());

    }

    public int randomEmployee() {
        int countedOfEmployees = countEmployees();
        Random r = new Random();
        return r.nextInt((countedOfEmployees - 1) + 1) + 1;
    }

    private int countEmployees() {
        return jdbcTemplate.queryForObject("SELECT COUNT(id) FROM Employee", int.class);
    }

}
