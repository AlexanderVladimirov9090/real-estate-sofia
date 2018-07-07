package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
    JdbcTemplate jdbcTemplate;
    class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Seller();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setPhone(rs.getString("phone"));
            customer.setType(Seller.class);

            return customer;
        }
    }

    public List<Customer> findAll(){
        return jdbcTemplate.query("SELECT * FROM Customer UNION SELECT * FROM Seller", new CustomerRowMapper());
    }

    public Seller findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Customer UNION SELECT * FROM Seller WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<Seller>(Seller.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM CUSTOMER WHERE id=?", new Object[]{id});
    }
    public int insert(Customer customer){
      /*  return jdbcTemplate.update("INSERT INTO Agency (id, name, address, contactByPhone) " + "VALUES(?, ?, ?, ?)",
                new Object[]{customer.getId(),customer.getName(),customer.getContactByPhone()});
   */
      return 0;
    }
    public int update(Agency agency){
        return jdbcTemplate.update("UPDATE Agency" + "SET name=?, address=?, contactByPhone=?  "+ "WHERE id=?",
                new Object[]{agency.getName(),agency.getAddress(),agency.getContactByPhone(),agency.getId()});
    }
}
