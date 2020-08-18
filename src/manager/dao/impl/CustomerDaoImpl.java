package manager.dao.impl;

import manager.dao.CustomerDao;
import manager.domain.Customer;
import manager.util.StreamUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean addCustomer(Customer customer) {
        return StreamUtils.add(Customer.class, customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return StreamUtils.findAll(Customer.class);
    }

    @Override
    public boolean deleteCustomerById(String delId) {
        return StreamUtils.deleteById(Customer.class, delId);
    }

    @Override
    public Customer getById(String id) {
        return StreamUtils.getById(Customer.class, id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return StreamUtils.update(Customer.class, customer);
    }

    @Override
    public int checkout(int totalPrice, String id) {
        int finalPrice = 0;
        if (totalPrice < 100) {
            finalPrice = totalPrice;
        } else if (totalPrice >= 100 && totalPrice <= 200) {
            finalPrice = (int) ((totalPrice - 100) * 0.9 + 100);
        } else if (totalPrice > 200 && totalPrice <= 500) {
            finalPrice = (int) ((totalPrice - 200) * 0.8 + 190);
        } else {
            finalPrice = (int) ((totalPrice - 500) * 0.7 + 350);
        }
        Customer byId = getById(id);
        String[] split = byId.toTxt().split(",");
        int writePrice = Integer.parseInt(split[3]) - finalPrice;
        byId.setMoney(Integer.toString(writePrice));
        addCustomer(byId);

        return finalPrice;
    }
}
