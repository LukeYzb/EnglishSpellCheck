package manager.domain;

public class Fruit extends Object {

    private String amount;

    public Fruit() {
    }

    public Fruit(String id, String name, String age, String amount) {
        super(id, name, age);
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
