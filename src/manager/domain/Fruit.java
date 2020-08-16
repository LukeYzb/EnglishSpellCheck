package manager.domain;

public class Fruit extends Obj {
//amount数量
    private String amount;

    public Fruit() {
    }
//id水果id，name水果名称，price水果价格
    public Fruit(String id, String name, String price, String amount) {
        super(id, name, price);
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
