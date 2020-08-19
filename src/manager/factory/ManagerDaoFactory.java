package manager.factory;

import manager.dao.impl.ManagerDaoImpl;

public class ManagerDaoFactory {
    public static ManagerDaoImpl getManagerDao() {
        return new ManagerDaoImpl();
    }
}
