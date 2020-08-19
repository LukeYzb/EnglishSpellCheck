package manager.factory;

import manager.dao.CustomerDao;
import manager.dao.impl.CustomerDaoImpl;

public class CustomerDaoFactory {
    public static CustomerDao getCustomerDao() {
        return new CustomerDaoImpl();
    }
}
