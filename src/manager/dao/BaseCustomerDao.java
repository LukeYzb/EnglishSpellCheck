package manager.dao;

import manager.domain.Customer;

public interface BaseCustomerDao {
    //        创建老师数组
    static Customer[] customers = new Customer[2];

    public boolean addCustomer(Customer customer);

    public Customer[] findAllCustomer();

    public void deleteCustomerById(String delId);

    public int getIndex(String id);

    public void updateCustomer(String updateId, Customer newmanager);
}
