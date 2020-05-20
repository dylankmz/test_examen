package be.ehb.demo.dao;

import be.ehb.demo.entity.GroceryList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemDAO extends CrudRepository<GroceryList, Integer> {
    public List<GroceryList> findItemById(int id);
    public List<GroceryList> findAllByCategory(String category);

}
