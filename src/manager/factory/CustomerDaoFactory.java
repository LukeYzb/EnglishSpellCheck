package manager.factory;

import manager.dao.BaseCustomerDao;
import manager.dao.OtherCustomerDao;

public class CustomerDaoFactory {
    public static BaseCustomerDao getCustomerDao(){
        return new OtherCustomerDao();
    }
}
