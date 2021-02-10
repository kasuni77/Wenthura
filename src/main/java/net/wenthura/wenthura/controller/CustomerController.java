package net.wenthura.wenthura.controller;
import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Customer;

import net.wenthura.wenthura.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cus")
public class CustomerController{
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {

        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
                                                   @Valid @RequestBody Customer employeeDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + customerId));

        customer.setCname(employeeDetails.getCname());
        customer.setCaddress(employeeDetails.getCaddress());
        customer.setCnic(employeeDetails.getCnic());
        customer.setCemail(employeeDetails.getCemail());
        customer.setCphone(employeeDetails.getCphone());
        customer.setCpassword(employeeDetails.getCpassword());

v
        final Customer updatedCusomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCusomer);
    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
