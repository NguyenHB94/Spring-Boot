package com.example.springday03.controller;

import com.example.springday03.model.Customer;
import com.example.springday03.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
@CrossOrigin(value = "*")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        var result = this.customerService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
        return ResponseEntity.ok(this.customerService.getById(customerId));
    }

    @PostMapping("")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer) {
        var ret = this.customerService.create(newCustomer);
        if (ret) {
            return ResponseEntity.created(URI.create("/")).body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomerById(
            @RequestBody Customer newCustomer,
            @PathVariable("customerId") Integer customerId) {
        var ret = this.customerService.update(customerId,newCustomer);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") Integer customerId) {
        var ret = this.customerService.deleteById(customerId);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
