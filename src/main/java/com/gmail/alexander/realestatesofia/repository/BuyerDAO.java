package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.models.costumers.Buyer;
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
public class BuyerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * This class is used to Map Data to The objects fields.
     */
    class BuyerRowMapper implements RowMapper<Buyer> {

        /**
         * Maps data to Object
         *
         * @param rs     is used to store all data from database and then extracted to the object`s fields.
         * @param rowNum Store what number of a row are we in.
         * @return Object from given class.
         * @throws SQLException
         */
        @Override

        public Buyer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Buyer buyer = new Buyer();
            buyer.setId(rs.getInt("id"));
            buyer.setName(rs.getString("name"));
            buyer.setPhone(rs.getString("phone"));
            buyer.setBudget(rs.getDouble("budget"));
            buyer.getEmployee().setId(rs.getInt("employee_id"));
            return buyer;
        }
    }
    /**
     * Finds all Records of Buyer
     *
     * @return
     */

    public List<Buyer> findAll() {
        return jdbcTemplate.query("SELECT Buyer.id, budget, name, phone, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID ", new BuyerRowMapper());

    }

    /**
     * Gets a list of buyers by Employee`s id.
     * @param id given employee`s id
     * @return
     */
    public List<Buyer> findBuyersByEmployeeId(int id) {
        return jdbcTemplate.query("SELECT Buyer.id, budget, name, phone, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID WHERE Buyer.employee_id=?",  new Object[]{id}, new BuyerRowMapper());
    }

    public Buyer findTopByOrderByIdDesc(){
        return jdbcTemplate.queryForObject("SELECT Buyer.id, budget, name, phone, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID ORDER BY ID DESC LIMIT 1",  new BuyerRowMapper());
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Buyer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Buyer.id, name, phone, budget, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID WHERE Customer.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Buyer>(Buyer.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Buyer WHERE id=?", id);
    }
    /**
     * This is used to insert record to the database.
     * @param buyer
     * @return
     */

    public int insert(Buyer buyer) {

        return jdbcTemplate.update("INSERT INTO Buyer (id, BUDGET, EMPLOYEE_ID) " + "VALUES((SELECT id FROM CUSTOMER WHERE phone=?), ? , (SELECT id FROM EMPLOYEE WHERE id=? ))",
               buyer.getPhone(), buyer.getBudget(), employeeDAO.randomEmployee());
    }

    /**
     * Updates record from database by id.
     * @param buyer updated version of the record.
     * @return confirmation code.
     */
    public int update(Buyer buyer) {
        return jdbcTemplate.update("UPDATE Buyer " + "SET BUDGET=?  " + "WHERE id=(SELECT id FROM CUSTOMER WHERE id=?    )",
                buyer.getBudget(), buyer.getId());
    }
}
