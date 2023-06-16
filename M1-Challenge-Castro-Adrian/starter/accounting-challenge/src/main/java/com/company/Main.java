package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static List<Customer> makeCustomerList(List<String[]> customerData, List<Customer> customerList){
        for (String[] data : customerData){
            //determines whether a new customer is added to customerList once there's more than 0 customers
            boolean shouldContinue = false;

            //enters first customer so arraylist isn't empty, because checking for existing
            //customers is dependent on there being at least one customer in customerList
            //then adds to the customer's charges ArrayList
            //this code should only run ONCE, then continue to the next iteration
            if (customerList.isEmpty()){
                addNewCustomer(data, customerList);
                storeCharges(data, customerList, 0);
                continue;
            }

            //if customer has already been added to customerList, add to existing customer's charges
            for (int i = 0; i < customerList.size(); i++){
                if (Integer.parseInt(data[0]) == (customerList.get(i).getId())){
                    storeCharges(data, customerList, i);
                    shouldContinue = true; //makes sure customer isn't accidentally added as new
                    break;
                }
            }

            //if customer already exists, it should not be added as a new customer and skip the following code
            if (shouldContinue){
                continue;
            }
            //make a new customer object and add it to customerList, since the customer is confirmed
            //to not have been already added, then added to the customer's charges ArrayList
            else{
                addNewCustomer(data, customerList);
                storeCharges(data, customerList, customerList.size()-1);
            }

        } //END OF ITERATING THROUGH customerData

        return customerList;
    }

    //HELPER METHOD: adds new customers to customerList
    public static List<Customer> addNewCustomer(String[] data, List<Customer> customerList){
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(data[0]));
        customer.setName(data[1]);
        customerList.add(customer);
        return customerList;
    }

    //HELPER METHOD: adds customerData to an AccountRecord, adds AccountRecord to
    //corresponding customer's charges
    public static List<Customer> storeCharges(String[] data, List<Customer> customerList, int index){
        //makes new AccountRecord and stores the charge and chargeDate
        AccountRecord newAccount = new AccountRecord();
        newAccount.setCharge(Integer.parseInt(data[2]));
        newAccount.setChargeDate(data[3]);
        customerList.get(index).getCharges().add(newAccount);
        return customerList;
    }

    public static void main(String[] args) {
        //Update this

        //keeps track of whether a customer has been added yet and stores their charges
        List<Customer> customerList = new ArrayList<>();
        List<Customer> positiveAccounts = new ArrayList<>();
        List<Customer> negativeAccounts = new ArrayList<>();

        makeCustomerList(customerData, customerList);

        for (Customer customer : customerList){
            if (customer.getBalance() < 0){
                negativeAccounts.add(customer);
            }
            else{
                positiveAccounts.add(customer);
            }
        }

        System.out.println("Positive accounts:");
        for (Customer customer : positiveAccounts){
            System.out.println(customer);
        }

        System.out.println("Negative accounts:");
        for (Customer customer : negativeAccounts){
            System.out.println(customer);
        }
    }
}
