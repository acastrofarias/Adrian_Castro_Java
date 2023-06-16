package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int sum = 0;
        for (AccountRecord charge : charges){
            sum += charge.getCharge();
        }
        return sum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(getId() + ", ");
        sb.append("Name: ");
        sb.append(getName() + ", ");
        sb.append("Balance: ");
        sb.append(getBalance());
        String singleString = sb.toString();
        return singleString;
    }
}
