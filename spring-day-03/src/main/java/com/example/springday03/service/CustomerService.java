package com.example.springday03.service;

import com.example.springday03.model.Customer;
import com.example.springday03.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return this.customerRepository.getAll();
    }

    public Customer getById(Integer id) {
        var customer = customerRepository.getById(id);
        return customer.orElse(null);
    }

    public boolean create(Customer newCustomer) {
        var ret = this.customerRepository.add(newCustomer);
        return ret != null;
    }

    public boolean update(Integer id, Customer newCustomer) {
        var ret  = this.customerRepository.update(newCustomer, id);
        return ret.isPresent();
    }

    public boolean deleteById(Integer id) {
        return this.customerRepository.delete(id);
    }

}
