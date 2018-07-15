package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
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
     * This class is used to Map Data to The objects fields.
     */
    class SellerRowMapper implements RowMapper<Seller> {

        /**
         * Maps data to Object
         *
         * @param rs     is used to store all data from database and then extracted to the object`s fields.
         * @param rowNum Store what number of a row are we in.
         * @return Object from given class.
         * @throws SQLException
         */
        @Override
        public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
            Seller seller = new Seller();
            seller.setId(rs.getInt("id"));
            seller.setName(rs.getString("name"));
            seller.setPhone(rs.getString("phone"));
            return seller;
        }
    }
    /**
     * Finds all Records of Seller
     *
     * @return
     */

    public List<Seller> findAll() {
        return jdbcTemplate.query("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID", new SellerRowMapper());
    }

    public List<Seller> findBuyersByEmployeeId(int id) {
        return jdbcTemplate.query("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID WHERE Seller.employee_id=?",  new Object[]{id}, new SellerRowMapper());

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
