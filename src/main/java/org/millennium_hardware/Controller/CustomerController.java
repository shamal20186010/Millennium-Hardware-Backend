package org.millennium_hardware.Controller;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Service.CustomerService;
import org.millennium_hardware.dto.Customer;
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
            customerService.saveCustomer(customer);
            // Respond with success message
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "User successfully registered"));
        } catch (Exception e) {
            // Handle any errors, such as user already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

    @PutMapping("/update-customer")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        try {
            customerService.updateCustomerById(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "User successfully update"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete-customer-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {
        if (!customerService.existsById(id)) {
            throw new ProductNotFoundException("Customer with ID " + id + " not found.");
        }
        customerService.deleteCustomerById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Customer deleted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/search-by-customer/{id}")
    public Customer searchByName(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/getAll-customer")
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customerList = customerService.getCustomer();
        return ResponseEntity.ok(customerList);
    }
}
