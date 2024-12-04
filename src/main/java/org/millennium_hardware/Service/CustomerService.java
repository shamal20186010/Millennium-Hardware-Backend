package org.millennium_hardware.Service;

import org.millennium_hardware.dto.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomerById(Customer customer);

}
