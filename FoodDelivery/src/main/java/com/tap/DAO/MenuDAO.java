package com.tap.DAO;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDAO {

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(int id);

    Menu getMenu(int id);

    List<Menu> getAllMenus();

    List<Menu> getMenuByRestaurantId(int restaurantId);

    // New method
    Menu getMenuById(int menuId);
}