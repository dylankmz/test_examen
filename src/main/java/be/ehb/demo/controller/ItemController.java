package be.ehb.demo.controller;

import be.ehb.demo.dao.ItemDAO;
import be.ehb.demo.entity.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    

}
