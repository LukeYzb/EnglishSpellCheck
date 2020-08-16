package manager.factory;

import manager.dao.FruitDao;
import manager.dao.impl.FruitDaoImpl;

public class FruitDaoFactory {
    public static FruitDao getFruitDao(){
        return new FruitDaoImpl();
    }
}
