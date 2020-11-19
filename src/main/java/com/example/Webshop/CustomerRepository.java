package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private DataSource dataSource;

    public void saveCustomer(Customer customer) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL, ADDRESS, COUNTRY,ZIPCODE) VALUES (?,?,?,?,?,?)")) {
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getZipcode());
        ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
