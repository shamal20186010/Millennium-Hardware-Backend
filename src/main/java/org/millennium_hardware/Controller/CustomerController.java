package org.millennium_hardware.Controller;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Service.CustomerService;
import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.exception.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    @Autowired
    final CustomerService customerService;

    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        try {
            //save Customer
            customerService.saveProduct(customer);
            // Respond with success message
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "User successfully registered"));
        } catch (Exception e) {
            // Handle any errors, such as user already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

}
