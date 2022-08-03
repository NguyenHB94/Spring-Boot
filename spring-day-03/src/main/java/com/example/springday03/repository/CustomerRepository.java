package com.example.springday03.repository;

import com.example.springday03.FakeDB;
import com.example.springday03.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CustomerRepository {
    public List<Customer> getAll() {
        return FakeDB.database;
    }

    public Optional<Customer> getById(Integer id) {
        return FakeDB.database.stream()
                .filter(f -> Objects.equals(f.getId(), id))
                .findAny();
    }

    public Customer add(Customer newCustomer) {
        FakeDB.database.add(newCustomer);
        return newCustomer;
    }

    public Optional<Customer> update(Customer newCustomer, Integer id ) {
        var oldCustomer = this.getById(id);
        if (oldCustomer.isPresent()) {
            var realCustomer = oldCustomer.get();
            realCustomer.setId(newCustomer.getId());
            realCustomer.setName(newCustomer.getName());
            realCustomer.setAddress(newCustomer.getAddress());
            realCustomer.setTel(newCustomer.getTel());

            return Optional.of(realCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }

    }

    public boolean delete(Integer id) {
       return FakeDB.database.removeIf(customer -> Objects.equals(customer.getId(), id));
    }
}
