package manager.dao;

import manager.domain.Customer;

public class OtherCustomerDao implements BaseCustomerDao{
    //        创建顾客数组
    private static Customer[] customers =new Customer[2];
    public boolean addCustomer(Customer customer) {

//        添加顾客到数组，判断顾客是否存在
        int index=-1;
        for (int i = 0; i < customers.length; i++) {
            Customer customer1 = customers[i];
//            如果ID不存在，用index记录ID
            if(customer1 ==null){
                index=i;
                break;
            }
        }
        if(index==-1){//装满了
            return false;
        }else {//没装满，正常添加
            customers[index]= customer;
            return true;
        }
    }

    public Customer[] findAllCustomer() {
        return customers;
    }

    public void deleteCustomerById(String delId) {
//        查找ID在容器中的索引位置
        int index=getIndex(delId);
//        将该位置用null覆盖
        customers[index]=null;
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < customers.length; i++) {
            Customer customer = customers[i];
            if(customer !=null&& customer.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateCustomer(String updateId, Customer newmanager) {
//        查找ID所在索引位置
        int index=getIndex(updateId);
//        该索引位置替换
        customers[index]=newmanager;
    }
}
