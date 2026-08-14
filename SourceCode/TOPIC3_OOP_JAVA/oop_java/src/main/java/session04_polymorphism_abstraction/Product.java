package session04_polymorphism_abstraction;

//lớp trừu tượng Product: lớp cha các thuộc tính chung
public abstract class Product {
    private int id;
    private String name;
    protected float price;

    // contructor
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // method toString
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Price: $%.2f", id, name, price);
    }

}
