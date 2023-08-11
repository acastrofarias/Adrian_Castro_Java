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
        customer.setPhone("021-0569");
        customer.setAddress1("Magic Ave");
        customer.setAddress2("Disney World");
        customer.setCity("Orlando");
        customer.setState("FL");
        customer.setPostalCode("00000");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateExistingCustomer() {
        Customer customer = new Customer();
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

        customer.setFirstName("Michael");
        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteExistingCustomer() {
        Customer customer = new Customer();
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

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);

        customerRepository.deleteById(customer.getId());

        customer1 = customerRepository.findById(customer.getId());

        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        Customer customer = new Customer();
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

        Customer customer1 = new Customer();
        customer1.setFirstName("Charles");
        customer1.setLastName("Cheese");
        customer1.setEmail("entertainment@gmail.com");
        customer1.setCompany("Chuck E Cheese");
        customer1.setPhone("021-0569");
        customer1.setAddress1("Family Fun Street");
        customer1.setAddress2("For Everyone");
        customer1.setCity("San Diego");
        customer1.setState("CA");
        customer1.setPostalCode("00000");
        customer1.setCountry("USA");

        customer1 = customerRepository.save(customer1);

        Optional<Customer> foundCustomer = customerRepository.findById(customer1.getId());

        assertEquals(foundCustomer.get(), customer1);

    }

    @Test
    public void shouldGetCustomerByState() {
        Customer customer = new Customer();
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

        List<Customer> customer1 = customerRepository.findByState("FL");

        assertEquals(customer1.size(), 1);
    }
}
