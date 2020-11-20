package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ItemsRepository {
    @Autowired
    private DataSource dataSource;

    List<Item> items = new ArrayList<>();

    public List<Item> sortItemsByPriceAscending() {
        Collections.sort(items, Comparator.comparingInt(Item::getPrice));
        return items;
    }

    public List<Item> sortItemsByPriceDescending() {
        Collections.sort(items, Comparator.comparingInt(Item::getPrice).reversed());
        return items;
    }

    public List<Item> getItems() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery
                     ("SELECT ID,NAME,DESCRIPTION,PRICE,IMAGE FROM ITEM")) {
            while (resultSet.next()) {
                items.add(rsItems(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    private Item rsItems(ResultSet rs) throws SQLException {
        return new Item(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getString("image"));
    }
}
