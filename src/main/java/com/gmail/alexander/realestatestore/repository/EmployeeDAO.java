package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.concrete.Employee;
import com.gmail.alexander.realestatestore.repository.rowmappers.EmployeeRowMapper;
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
    @Autowired
    private final AgencyDAO agencyDAO;

    public EmployeeDAO(AgencyDAO agencyDAO) {
        this.agencyDAO = agencyDAO;
    }

    /**
     * Finds all Records of Employee
     *
     * @return
     */
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM Employee", new EmployeeRowMapper());
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Employee WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    /**
     * Fetching last recoded data.
     *
     * @return
     */
    public Employee findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT * FROM Employee ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Employee WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param employee
     * @return
     */
    public int insert(Employee employee) {
        employee.setId(countEmployees() + 1);
        return jdbcTemplate.update("INSERT INTO Employee ( NAME, PHONE, agency_id) " + "VALUES(?, ?, (SELECT id FROM AGENCY WHERE id=? ) )",
                employee.getName(), employee.getPhone(), employee.getAgency().getId());

    }

    /**
     * Updates record from database by id.
     *
     * @param employee updated version of the record.
     * @return confirmation code.
     */
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE Employee" + "SET NAME=?, PHONE=?  " + "WHERE ID=?"
                , employee.getName(), employee.getPhone(), employee.getId());

    }

    /**
     * Gives random id of an employee
     *
     * @return random id.
     */
    public int randomEmployee() {
        //counts employees
        int countedOfEmployees = countEmployees();
        Random r = new Random();
        //returns random id.
        return r.nextInt((countedOfEmployees - 1) + 1) + 1;
    }

    /**
     * Counts the employees in the database.
     *
     * @return how many employees are.
     */
    private int countEmployees() {
        return jdbcTemplate.queryForObject("SELECT COUNT(id) FROM Employee", int.class);
    }

}
