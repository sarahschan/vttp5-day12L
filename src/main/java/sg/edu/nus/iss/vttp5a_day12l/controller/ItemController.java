package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_day12l.model.Item;
import sg.edu.nus.iss.vttp5a_day12l.service.ItemService;


@Controller
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    ItemService itemService;
    
    @GetMapping("")
    public String cartItems(Model model) {
        
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);

        return "cartlist";

    }


    @GetMapping("/filter")  // in the URL: http://localhost:8080/items/filter?itemQuantity=20
    public String filterCartItems(@RequestParam(name = "itemQuantity") String quantity, Model model) {
        
        List<Item> items = itemService.getItems();
        List<Item> filteredItems = items.stream()
                                    .filter(a -> a.getQuantity() >= Integer.parseInt(quantity))
                                    .collect(Collectors.toList());

        model.addAttribute("items", filteredItems);
        
        return "cartlist";

    }

}
