package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private DataSource dataSource;

    public void saveCustomer(Customer customer) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL, ADDRESS, " +
                             "COUNTRY,ZIPCODE, PASSWORD) VALUES (?,?,?,?,?,?,?)")) {
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getCountry());
        ps.setString(6, customer.getZipcode());
        ps.setString(7, customer.getPassword());
        ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer findByUserName(String email){
        Customer customer = null;

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery
                     ("SELECT * FROM CUSTOMER WHERE EMAIL = '"+ email +"'")) {
            if (resultSet.next()) {
                customer = rsCustomer(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    private Customer rsCustomer(ResultSet rs) throws SQLException {
        return new Customer(rs.getLong("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("address"),
                rs.getString("country"),
                rs.getString("zipcode"),
                rs.getString("password"));
    }
}
