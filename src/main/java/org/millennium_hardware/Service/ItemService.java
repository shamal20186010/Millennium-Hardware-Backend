package org.millennium_hardware.Service;

import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.dto.Item;

public interface ItemService {
    void saveItem(Item item);
    void updateItemById(Item item);
}
