package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldAddCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Mickey");
        customer.setLastName("Mouse");
        customer.setEmail("meeskamooska@gmail.com");
        customer.setCompany("Disney");
        customer.setPhone("212-021-0569");
        customer.setAddress1("Magic Ave");
        customer.setAddress2("Disneyworld");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("00000");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateExistingCustomer() {

    }

    @Test
    public void shouldDeleteExistingCustomer() {

    }

    @Test
    public void shouldGetCustomerById() {

    }

    @Test
    public void shouldGetCustomerByState() {

    }
}
