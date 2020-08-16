package manager.dao.impl;

import manager.dao.CustomerDao;
import manager.domain.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean addCustomer(Customer customer) throws IOException {
        //如果ID存在,不能继续添加
        Customer byId = getById(customer.getId());
        if (byId == null) {
            return false;
        }
        //得到findAllCustomer的List
        List<Customer> allCustomer = findAllCustomer();
        //在List里添加参数customer
        allCustomer.add(customer);
        //将新的List写入IO流
        BufferedWriter bw = new BufferedWriter(new FileWriter("fruitshop\\customer.txt"));
        //list遍历,totxt
        for (Customer customer1 : allCustomer) {
            String s = customer1.toTxt();
            bw.write(s);
        }
        bw.close();
        return true;
    }

    @Override
    public List<Customer> findAllCustomer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fruitshop\\customer.txt"));
        String s;
        List<Customer> customers = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            Customer customer = Customer.toObj(s);
            customers.add(customer);
        }
        br.close();

        return customers;
    }

    @Override
    public boolean deleteCustomerById(String delId) {
        return false;
    }

    @Override
    public Customer getById(String id) {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}
