package com.gmail.alexander.realestatestore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RealEstateDAO {
    //This annotation is used to indicate that it will using JDBC drivers.
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
