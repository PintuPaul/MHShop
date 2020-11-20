package com.example.Webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/login")
    String signIn() {
        return "login";
    }

    @GetMapping("/myAccount")
    String accountInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("username = " + username);
        Customer customer = customerRepository.findByUserName(username);
        model.addAttribute("customer",customer);
        return "myAccount";
    }

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam String email, @RequestParam String address,
                               @RequestParam String password,
                               @RequestParam String country, @RequestParam String zipcode){
        Customer customer = new Customer(firstName, lastName, email, address, country, zipcode,password);
        customerRepository.saveCustomer(customer);
        return "redirect:/";
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
