package org.millennium_hardware.Service;

import org.millennium_hardware.dto.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);

    void updateCustomerById(Customer customer);

    boolean existsById(Long id);

    void deleteCustomerById(Long id);

    Customer findById(Long id);

    List<Customer> getProduct();
}
