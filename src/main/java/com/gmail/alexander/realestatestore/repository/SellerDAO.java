package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.concrete.Employee;
import com.gmail.alexander.realestatestore.models.costumers.Buyer;
import com.gmail.alexander.realestatestore.models.costumers.Seller;
import com.gmail.alexander.realestatestore.repository.rowmappers.SellerRowMapper;
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
public class SellerDAO {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Finds all Records of Seller
     *
     * @return
     */
    public List<Seller> findAll() {
        return jdbcTemplate.query("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID", new SellerRowMapper());
    }

    /**
     * Fetching recoded by id.
     *
     * @return
     */
    public List<Seller> findBuyersByEmployeeId(int id) {
        return jdbcTemplate.query("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID WHERE Seller.employee_id=?", new Object[]{id}, new SellerRowMapper());

    }

    /**
     * Fetching last recoded data.
     *
     * @return
     */
    public Seller findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Seller>(Seller.class));
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Seller findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID WHERE Customer.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Seller>(Seller.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Seller WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param seller
     * @return
     */
    public int insert(Seller seller) {
        return jdbcTemplate.update("INSERT INTO Seller (ID, EMPLOYEE_ID) " + "VALUES((SELECT id FROM CUSTOMER WHERE phone=?), (SELECT id FROM EMPLOYEE WHERE id=? ))",
                seller.getPhone(), employeeDAO.randomEmployee());
    }

    //TODO update()!
}
