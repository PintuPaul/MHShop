package com.example.Webshop.old;

import com.example.Webshop.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ItemRepository {
    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
       /* items.add(new Item("Summer Dress", "Dress perfectly comfortable for warm summer weather", 200, "https://lp2.hm.com/hmgoepprod?set=source[/c8/8f/c88fb442ba7d1ddcd8bdbe4421ec30bb0c0c82fc.jpg],origin[dam],category[ladies_dresses_aline],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Summer Jacket", "Reasonably warm jacket for when it's not too cold", 800, "https://lp2.hm.com/hmgoepprod?set=source[/57/25/5725eb550073daaf3b9407563eebbb65c85c555a.jpg],origin[dam],category[ladies_sport_jackets],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Denim Jeans", "Your typical blue denim jeans", 400, "https://lp2.hm.com/hmgoepprod?set=source[/03/00/03000d915fc100d87295be41b41c1944038086d2.jpg],origin[dam],category[ladies_jeans_slim],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Winter Jacket", "Make sure you survive this years winter with this really warm winter jacket", 1400, "https://lp2.hm.com/hmgoepprod?set=source[/7b/51/7b512d298ba0b00c43e3d4a6e0cb515368cc052a.jpg],origin[dam],category[ladies_jacketscoats_jackets],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/fullscreen]"));
        items.add(new Item("Coat", "Dress dashingly in this sweet coat", 680, "https://lp2.hm.com/hmgoepprod?set=source[/ad/65/ad6504ce3c6330a112723602e620101eca490b66.jpg],origin[dam],category[ladies_jacketscoats_coats],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Leather Gloves", "Fits any hand", 250, "https://lp2.hm.com/hmgoepprod?set=source[/fa/bd/fabdf7d8b8a17461564f46e82247438d0448983b.jpg],origin[dam],category[ladies_accessories_hatsscarvesgloves_gloves],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Sneakers", "Run quick and silent like a ninja with these sneakers", 900, "https://lp2.hm.com/hmgoepprod?set=source[/63/f0/63f0c0915ee951ada3d15fd92cfdcd5cc90fa039.jpg],origin[dam],category[men_shoes_sneakers],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Leather Boots", "These boots were made for walkin'", 1300, "https://lp2.hm.com/hmgoepprod?set=source[/77/5e/775ef2411ab864f5474aa50e5cd637aa6a1cf6a4.jpg],origin[dam],category[ladies_shoes_ankle_boots],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Regular T-Shirt", "Perfect for any occasion", 100, "https://lp2.hm.com/hmgoepprod?set=source[/06/af/06afb43f7965b3310682da3ff04abb39f173e49c.jpg],origin[dam],category[ladies_basics_tops_shortsleeve],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Deluxe T-Shirt", "Even more perfect for any occasion", 130, "https://lp2.hm.com/hmgoepprod?set=source[/74/6f/746fead375797edb33c421f5c70a5383e36af5a0.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Regular Hoodie", "Keep yourself warm with the option to cover your head", 250, "https://lp2.hm.com/hmgoepprod?set=source[/8b/f5/8bf5406917f0e813793c720c04e2fd6d5adb59ee.jpg],origin[dam],category[ladies_cardigansjumpers_hoodiessweatshirts],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Deluxe Hoodie", "Keep yourself warm and stylish with the option to cover your head", 400, "https://lp2.hm.com/hmgoepprod?set=source[/eb/a8/eba89b46f4c8523a3cdb9266625763d0a9faa7b7.jpg],origin[dam],category[ladies_cardigansjumpers_jumpers],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Regular Shirt", "Get this for your first interview", 140, "https://lp2.hm.com/hmgoepprod?set=source[/a8/3b/a83be7491ca71977cbb4b22cf2604b6ebe49406b.jpg],origin[dam],category[ladies_shirtsblouses_shirts],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Deluxe Shirt", "Get this after your first salary", 240, "https://lp2.hm.com/hmgoepprod?set=source[/fc/6e/fc6eb597ca43fc54f902104b8071097f6c14a94d.jpg],origin[dam],category[ladies_shirtsblouses_shirts],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Item("Flip-Flops", "Make annoying sound wherever you go!", 40, "https://lp2.hm.com/hmgoepprod?set=source[/ce/04/ce0474ef9c8d4c6732f304063c17410efe0cec04.jpg],origin[dam],category[men_shoes_sandals_espandrillos],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/fullscreen]"));
   */ }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeAllItems(){
        items.clear();
    }

    public List<Item> sortItemsByPriceAscending() {
        Collections.sort(items, Comparator.comparingInt(Item::getPrice));
        return items;
    }

    public List<Item> sortItemsByPriceDescending() {
        Collections.sort(items, Comparator.comparingInt(Item::getPrice).reversed());
        return items;
    }


}
