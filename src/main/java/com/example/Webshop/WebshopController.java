package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WebshopController {
    @Autowired
    private ItemRepository repository;

    @GetMapping("/")
    String welcome(){
        return "landingPage";
    }

    @GetMapping("/productList")
    String productList(Model model){
        List<Item> products = repository.getItems();
        model.addAttribute("product", products.get(0));
        return "productList";
    }

    @GetMapping("/shoppingCart")
    String shoppingCart(Model model){
        return "shoppingCart";
    }

    @GetMapping("/landingPage")
    String welcomePage(){
        return "landingPage";
    }

    @GetMapping("/checkout")
    String checkout(){
        return "checkout";
    }
}
