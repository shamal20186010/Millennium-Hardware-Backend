package org.millennium_hardware.Controller;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Service.ItemService;
import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.dto.Item;
import org.millennium_hardware.exception.ProductNotFoundException;
import org.millennium_hardware.exception.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {

    @Autowired
    final ItemService itemService;

    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveCustomer(@RequestBody Item item) {
        try {
            //save Item
            itemService.saveItem(item);
            // Respond with success message
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "Item successfully added"));
        } catch (Exception e) {
            // Handle any errors, such as user already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

    @PutMapping("/update-item")
    public ResponseEntity<?> updateCustomer(@RequestBody Item item) {
        try {
            itemService.updateItemById(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "Item successfully update"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete-item-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {
        if (!itemService.existsById(id)) {
            throw new ProductNotFoundException("Item with ID " + id + " not found.");
        }
        itemService.deleteItemById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item deleted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/search-by-item/{id}")
    public Item searchByName(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/getAll-item")
    public ResponseEntity<List<Item>> getItem() {
        List<Item> itemList = itemService.getItem();
        return ResponseEntity.ok(itemList);
    }
}
