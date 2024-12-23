package org.millennium_hardware.Service;

import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.dto.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);

    void updateItemById(Item item);

    boolean existsById(Long id);

    void deleteItemById(Long id);

    Item findById(Long id);

    List<Item> getItem();
}
