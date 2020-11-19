package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebshopController {

    @Autowired
    private ItemsRepository repository;
    //private ItemRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    String welcome() {
        return "landingPage";
    }

    @GetMapping("/productList")
    String productList(Model model, @RequestParam(value = "sorting", defaultValue = "0") Integer sorting) {

        if (sorting == 1) {
            List<Item> products = repository.sortItemsByPriceAscending();
            model.addAttribute("products", products);
        } else if (sorting == 2) {
            List<Item> products = repository.sortItemsByPriceDescending();
            model.addAttribute("products", products);
        } else {
            List<Item> products = repository.getItems();
            model.addAttribute("products", products);
        }

        return "productList";
    }

    @GetMapping("/shoppingCart")
    String shoppingCart() {
        return "shoppingCart";
    }

    @GetMapping("/landingPage")
    String welcomePage() {
        return "landingPage";
    }

    @GetMapping("/checkout")
    String checkout() {
        return "checkout";
    }

    @GetMapping("/addCustomer")
    String addCustomer() {
        return "addCustomer";
    }

    @GetMapping("/signIn")
    String signIn() {
        return "signIn";
    }

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address, @RequestParam String country, @RequestParam String zipcode){
        Customer customer = new Customer(firstName, lastName, email, address, country, zipcode);
        customerRepository.saveCustomer(customer);
        return "redirect:/productList";
    }

    @PostMapping("/productList")
    public String addToCart(@RequestParam long id, @RequestParam String title, @RequestParam String description,
                            @RequestParam String image, @RequestParam int price, HttpSession session) {
        List<Item> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            session.setAttribute("sum", 0);
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        session.setAttribute("sum", (Integer) session.getAttribute("sum") + price);
        cart.add(new Item(id, title, description, price, image));
        return "redirect:/productList";
    }

    @GetMapping("/orderConfirmation")
    String orderConfirmation() {
        return "orderConfirmation";
    }

    @PostMapping("/removeItem")
    String removeItem(HttpSession session, @RequestParam String title) {
        List<Item> cart = (List) session.getAttribute("cart");
        if (cart != null) {
            for (Item item : cart) {
                if (item.getName().equals(title)) {
                    cart.remove(item);
                    session.setAttribute("sum", (Integer) session.getAttribute("sum") - item.getPrice());
                    break;
                }
            }
        }
        return "redirect:/shoppingCart";
    }

    @PostMapping("/redeem")
    String redeem(HttpSession session, @RequestParam String promoCode) {
        if (session.getAttribute("discount") == null && promoCode.equals("abcd")) {
            session.setAttribute("discount", 100);
            session.setAttribute("sum", (Integer) session.getAttribute("sum") - 100);
        }
        return "redirect:/checkout";
    }
}
