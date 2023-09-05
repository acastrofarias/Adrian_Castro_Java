package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CustomerControllerTests {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;

    private Customer customer;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() throws Exception {
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
    }

    @Test
    void addCustomer() throws Exception {
        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getCustomerById() throws Exception {
        mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCustomerByState() throws Exception {
        mockMvc.perform(get("/customers/state/FL"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCustomer() throws Exception {
        customer.setFirstName("UPDATED");
        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteCustomerById() throws Exception {
        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
