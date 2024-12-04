package org.millennium_hardware.Controller;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Service.ItemService;
import org.millennium_hardware.dto.Item;
import org.millennium_hardware.exception.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}