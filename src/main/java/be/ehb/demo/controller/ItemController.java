package be.ehb.demo.controller;

import be.ehb.demo.dao.ItemDAO;
import be.ehb.demo.entity.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemDAO dao;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<GroceryList> getAllItems() {
        return dao.findAll();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<GroceryList> getItemsById(@PathVariable(value = "id") int id) {
        return dao.findItemById(id);
    }

    @RequestMapping(value = "/items/{category}")
    @ResponseBody
    public List<GroceryList> getItemsByCategory(@PathVariable(value = "category") String category) {
        return dao.findAllByCategory(category);
    }

    @RequestMapping(value = "items/new", method = RequestMethod.POST)
    @ResponseBody
    public void createItem(@RequestParam(value = "name") String name,
                           @RequestParam(value = "unitPrice") double unitPrice,
                           @RequestParam(value = "amount") int amount,
                           @RequestParam(value = "category") String category) {

        GroceryList groceryList = new GroceryList(name, unitPrice, amount, category);
        dao.save(groceryList);
    }


}
