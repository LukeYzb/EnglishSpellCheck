package manager.factory;

import manager.dao.BaseFruitDao;
import manager.dao.OtherFruitDao;

public class FruitDaoFactory {
    public static BaseFruitDao getFruitDao(){
        return new OtherFruitDao();
    }
}
