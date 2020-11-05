package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    String shoppingCart(Model model, HttpSession session){
/*        List<Item> products =  (List)session.getAttribute("cart");
        model.addAttribute("product", products);*/
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

    @PostMapping("/productList")
    public String addToCart(@ModelAttribute Item item, HttpSession session) {
        List<Item> cart = (List)session.getAttribute("cart");
        if (cart == null) {
            session.setAttribute("sum",0);
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        session.setAttribute("sum",(Integer)session.getAttribute("sum")+item.getPrice());
        cart.add(item);
        return "redirect:/productList";
    }

    @GetMapping("/orderConfirmation")
    String orderConfirmation(){
        return "orderConfirmation";
    }
}
