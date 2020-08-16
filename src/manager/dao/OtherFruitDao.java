package manager.dao;

import manager.domain.Fruit;

import java.util.ArrayList;

public class OtherFruitDao implements BaseFruitDao {
    //        创建水果集合
    private static ArrayList<Fruit> fruits =new ArrayList<>();

//    用IO流传入Fruit对象，然后添加到fruits集合里
    private void IputFruit(){

    }
    //    用IO流传出Fruit对象，然后添加到fruits集合里
    private void OutputFruit(){

    }

    public boolean addFruit(Fruit fruit) {
        fruits.add(fruit);
        return true;
    }

    public Fruit[] findAllFruit() {
        Fruit[] customers1=new Fruit[fruits.size()];
        for (int i = 0; i < customers1.length; i++) {
            customers1[i]= fruits.get(i);
        }
        return customers1;
    }

    public void deleteFruitById(String delId) {
//        查找ID在容器中的索引位置
        int index=getIndex(delId);
//        将该位置用null覆盖
        fruits.remove(index);
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            if(fruit !=null&& fruit.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateFruit(String updateId, Fruit newcustomer) {
//        查找ID所在索引位置
        int index=getIndex(updateId);
//        该索引位置替换
        fruits.set(index,newcustomer);
    }
}
