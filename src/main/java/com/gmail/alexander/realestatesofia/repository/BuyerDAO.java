package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
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

    class BuyerRowMapper implements RowMapper<Buyer> {

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



    public List<Buyer> findAll() {
        return jdbcTemplate.query("SELECT Buyer.id, budget, name, phone, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID ", new BuyerRowMapper());

    }

    public Buyer findById(int id) {
return jdbcTemplate.queryForObject("SELECT Buyer.id, name, phone, budget, employee_id FROM Buyer INNER JOIN Customer ON Buyer.ID=Customer.ID WHERE Customer.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Buyer>(Buyer.class));
       }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Buyer WHERE id=?", id);
    }

    public int insert(Buyer buyer) {

        return jdbcTemplate.update("INSERT INTO Buyer (id, BUDGET, EMPLOYEE_ID) " + "VALUES((SELECT id FROM CUSTOMER WHERE id=? ), ? , (SELECT id FROM EMPLOYEE WHERE id=? ))",
                buyer.getId(), buyer.getBudget(),employeeDAO.randomEmployee());
    }

    public int update(Buyer buyer) {
        return jdbcTemplate.update("UPDATE Buyer " + "SET BUDGET=?  " + "WHERE id=(SELECT id FROM CUSTOMER WHERE id=?    )",
                buyer.getBudget(), buyer.getId());
    }

    public void buyProperty(Property property) {
        //TODO extract Buyers money and mark it as sold.
    }
}
