package com.example.Webshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebshopController {
    @GetMapping("/")
    String welcome(){
        return "landingPage";
    }
    @GetMapping("/productList")
    String productList(){
        return "productList";
    }
}
