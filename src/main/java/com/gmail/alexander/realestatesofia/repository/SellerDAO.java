package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.realesates.House;
import com.gmail.alexander.realestatesofia.entity.realesates.Land;
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

    class SellerRowMapper implements RowMapper<Seller> {

        @Override
        public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
            Seller seller = new Seller();
            seller.setId(rs.getInt("id"));
            seller.setName(rs.getString("name"));
            seller.setPhone(rs.getString("phone"));
            return seller;
        }
    }
    /*
* TODO
* SELECT Seller.id, name, phone, employee_id
FROM Seller
INNER JOIN Customer ON Seller.ID=Customer.ID;
SELECT * FROM ( SELECT * FROM Land UNION SELECT * FROM Property ) AS ALL_LAND ORDER
* */


    public List<Seller> findAll() {
        return jdbcTemplate.query("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID", new SellerRowMapper());
    }

    public Seller findById(int id) {
        return jdbcTemplate.queryForObject("SELECT Seller.id, name, phone, employee_id FROM Seller INNER JOIN Customer ON Seller.ID=Customer.ID WHERE Customer.ID=?", new Object[]{id}, new BeanPropertyRowMapper<Seller>(Seller.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Seller WHERE id=?", id);
    }

    public int insert(Seller seller) {
        return jdbcTemplate.update("INSERT INTO Seller (ID, EMPLOYEE_ID) " + "VALUES((SELECT id FROM CUSTOMER WHERE id=? ), (SELECT id FROM EMPLOYEE WHERE id=? ))",
                seller.getId(), employeeDAO.randomEmployee());
    }

    //TODO • Ако е продавач – да регистрира имо{
    // та си за продажба в агенцията. В такъв
    //случай от агенцията му се причислява агент на произволен принцип. Имотът
    //влиза в каталога на агенцията, а клиента – в списъка с продавачи на агента.
}
