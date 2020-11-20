package com.example.Webshop;

import com.example.Webshop.old.ItemRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Tests {

    @Test
    public void createItemAndGetPrice() {

/*        Item firstItem = new Item("firstItem", "PLACEHOLDER", 100, "PLACEHOLDER");
        Assert.assertEquals(100, firstItem.getPrice());


        Item secondItem = new Item("secondItem", "PLACEHOLDER", 200, "PLACEHOLDER");
        Assert.assertEquals(200, secondItem.getPrice());


        Item thirdItem = new Item("thirdItem", "PLACEHOLDER", 300, "PLACEHOLDER");
        Assert.assertEquals(300, thirdItem.getPrice());


        Item fourthItem = new Item("fourthItem", "PLACEHOLDER", 400, "PLACEHOLDER");
        Assert.assertEquals(400, fourthItem.getPrice());*/
    }

    @Test
    public void clearRepository() {

        ItemRepository itemRepositoryTest = new ItemRepository();
        itemRepositoryTest.removeAllItems();

        int result = itemRepositoryTest.getItems().size();
        Assert.assertEquals(0, result);
    }

    @Test
    public void getItemsSortedByPriceAscending() {

        ItemRepository itemRepositoryTest = new ItemRepository();
        itemRepositoryTest.removeAllItems();
/*
        itemRepositoryTest.addItem(new Item("Dress", "PLACEHOLDER", 3000, "PLACEHOLDER"));
        itemRepositoryTest.addItem(new Item("Shirt", "PLACEHOLDER", 1000, "PLACEHOLDER"));
        itemRepositoryTest.addItem(new Item("Coat", "PLACEHOLDER", 2000, "PLACEHOLDER"));
*/

        itemRepositoryTest.sortItemsByPriceAscending();
        List<Item> items = itemRepositoryTest.getItems();
        Assert.assertEquals("Shirt", items.get(0).getName());
        Assert.assertEquals("Coat", items.get(1).getName());
        Assert.assertEquals("Dress", items.get(2).getName());
    }

    @Test
    public void getItemsSortedByPriceDescending() {

        ItemRepository itemRepositoryTest = new ItemRepository();
        itemRepositoryTest.removeAllItems();
/*
        itemRepositoryTest.addItem(new Item("Dress", "PLACEHOLDER", 3000, "PLACEHOLDER"));
        itemRepositoryTest.addItem(new Item("Shirt", "PLACEHOLDER", 1000, "PLACEHOLDER"));
        itemRepositoryTest.addItem(new Item("Coat", "PLACEHOLDER", 2000, "PLACEHOLDER"));
*/

        itemRepositoryTest.sortItemsByPriceDescending();
        List<Item> items = itemRepositoryTest.getItems();
        Assert.assertEquals("Dress", items.get(0).getName());
        Assert.assertEquals("Coat", items.get(1).getName());
        Assert.assertEquals("Shirt", items.get(2).getName());
    }
}
