package org.millennium_hardware.Service.impl;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Repository.CustomerRepository;
import org.millennium_hardware.Service.CustomerService;
import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public void saveCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return mapper.map(customerRepository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> getProduct() {
        List<Customer> productArrayList = new ArrayList<>();
        customerRepository.findAll().forEach(entity -> {
            Customer product = mapper.map(entity, Customer.class);
            productArrayList.add(product);
        });
        return productArrayList;
    }
}
