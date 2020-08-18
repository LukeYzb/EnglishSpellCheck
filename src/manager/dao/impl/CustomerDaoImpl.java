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
}
