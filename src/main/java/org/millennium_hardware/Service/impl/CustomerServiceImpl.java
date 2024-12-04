package org.millennium_hardware.Service.impl;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Repository.CustomerRepository;
import org.millennium_hardware.Service.CustomerService;
import org.millennium_hardware.dto.Customer;
import org.millennium_hardware.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public void saveProduct(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }
}
