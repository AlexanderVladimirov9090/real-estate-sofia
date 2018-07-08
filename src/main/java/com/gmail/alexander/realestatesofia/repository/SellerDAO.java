package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
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
    ApartmentDAO apartmentDAO;
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    public List<Seller> findAll() {
        return jdbcTemplate.query("SELECT * FROM Seller", new SellerRowMapper());
    }

    public Seller findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Seller WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Seller>(Seller.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Seller WHERE id=?", id);
    }

    public int insert(Seller seller) {
        //TODO RandomEmployee(EmployeeDAO.countEmployees());
      /*  return jdbcTemplate.update("INSERT INTO Seller (ID, NAME, PHONE, REAL_ESTATE_EMPLOYEE_ID) " + "VALUES(?, ?, ?, (SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=? ))",
                new Object[]{customer.getId(),customer.getName(),customer.getContactByPhone()});
   */
        return 0;
    }

    public int update(Seller Seller) {
        //TODO Do the updated logic.
 /*       return jdbcTemplate.update("UPDATE Seller" + "SET name=?, address=?, contactByPhone=?  "+ "WHERE id=?",
                new Object[]{agency.getName(),agency.getAddress(),agency.getContactByPhone(),agency.getId()});
 */
        return 0;
    }

    public void registerSellingProperty(Seller seller) {
        switch (seller.getRealEstatesForSale().getRealEstateType()) {
            case "Apartment":
                Apartment sellingApartment = (Apartment) seller.getRealEstatesForSale();
                apartmentDAO.insert(sellingApartment);
                break;
            case "House":
                //TODO Register selling of a house.
                break;
            case "Land":
                //TODO register selling of a land.
                break;
        }
    }
}
