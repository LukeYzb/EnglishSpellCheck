package manager.dao;

import manager.domain.Fruit;

public interface BaseFruitDao {
    public abstract boolean addFruit(Fruit fruit);

    public abstract Fruit[] findAllFruit();

    public abstract void deleteFruitById(String delId);

    public abstract int getIndex(String id);

    public abstract void updateFruit(String updateId, Fruit newcustomer);
}
