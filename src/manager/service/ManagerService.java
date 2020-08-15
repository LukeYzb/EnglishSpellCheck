package manager.service;

import manager.dao.BaseCustomerDao;
import manager.domain.Customer;
import manager.factory.CustomerDaoFactory;

public class ManagerService {
    private BaseCustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
    public boolean addCustomer(Customer customer) {
//        顾客对象交给CustomerDao库管
//        CustomerDao customerDao=new CustomerDao();
//库管来找顾客是否存在
        return customerDao.addCustomer(customer);
    }

    public boolean isExists(String id) {
//        CustomerDao customerDao=new CustomerDao();
        Customer[] customers = customerDao.findAllCustomer();
//        假设id不存在
        boolean exists=false;
//        遍历数组
        for (int i = 0; i < customers.length; i++) {
            Customer customer = customers[i];
            if(customer !=null&& customer.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }

    public Customer[] findAllCustomer() {
//        用CustomerDao获取顾客数组
        Customer[] allCustomer = customerDao.findAllCustomer();
        boolean flag=false;
        for (int i = 0; i < allCustomer.length; i++) {
            Customer customer = allCustomer[i];
            if(customer !=null){
                flag=true;
                break;
            }
        }
        if(flag==true){
            return allCustomer;
        }else {
            return null;
        }
    }

    public void deleteCustomerById(String delId) {
        customerDao.deleteCustomerById(delId);
    }

    public void updateCustomer(String updateId, Customer newcustomer) {
        customerDao.updateCustomer(updateId,newcustomer);
    }
}
