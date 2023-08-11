package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();

        customer = new Customer();
        customer.setFirstName("Mickey");
        customer.setLastName("Mouse");
        customer.setEmail("meeskamooska@gmail.com");
        customer.setCompany("Disney");
        customer.setPhone("021-0569");
        customer.setAddress1("Magic Ave");
        customer.setAddress2("Disney World");
        customer.setCity("Orlando");
        customer.setState("FL");
        customer.setPostalCode("00000");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);
    }

    @Test
    public void shouldAddCustomer() {
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateExistingCustomer() {
        customer.setFirstName("Michael");
        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteExistingCustomer() {
        customerRepository.deleteById(customer.getId());
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldGetCustomerByState() {
        List<Customer> customer1 = customerRepository.findByState(customer.getState());
        assertEquals(1, customer1.size());
    }
}
