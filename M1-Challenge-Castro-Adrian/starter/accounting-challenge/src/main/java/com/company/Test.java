package com.company;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    List<Customer> customerList;

    @BeforeEach
    public void setUp(){
        customerList = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setName("Customer 1");
        customer1.setId(1);

        AccountRecord cus1Rec1 = new AccountRecord();
        cus1Rec1.setCharge(100);
        customer1.getCharges().add(cus1Rec1);

        AccountRecord cus1Rec2 = new AccountRecord();
        cus1Rec2.setCharge(200);
        customer1.getCharges().add(cus1Rec2);

        customerList.add(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Customer 2");
        customer2.setId(2);

        AccountRecord cus2Rec1 = new AccountRecord();
        cus2Rec1.setCharge(-100);
        customer2.getCharges().add(cus2Rec1);

        AccountRecord cus2Rec2 = new AccountRecord();
        cus2Rec2.setCharge(-200);
        customer2.getCharges().add(cus2Rec2);

        customerList.add(customer2);
    }

    @org.junit.jupiter.api.Test
    public void shouldToString(){
        assertEquals("ID: 1, Name: Customer 1, Balance: 300", customerList.get(0).toString());
        assertEquals("ID: 2, Name: Customer 2, Balance: -300", customerList.get(1).toString());
    }
    @org.junit.jupiter.api.Test
    public void shouldGetBalance(){
        assertEquals(300, customerList.get(0).getBalance());
        assertEquals(-300, customerList.get(1).getBalance());
    }
}
