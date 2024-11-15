package sg.edu.nus.iss.vttp5a_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day12l.model.Item;


@Repository
public class ItemRepo {
    
    private List<Item> itemList;

    public List<Item> getItems() {

        itemList = new ArrayList<>();

        Item item1 = new Item("Apple M4 Mini", 5);
        Item item2 = new Item("iPhone 16 Max Pro", 15);
        Item item3 = new Item("Prada Wallet", 25);
        Item item4 = new Item("Hermes Tote Bag", 10);
        Item item5 = new Item("LV Suitcase", 5);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        return itemList;
    }

    
}
