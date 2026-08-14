package session04_polymorphism_abstraction;

public class Electronics extends Product {
    private String brand;

    // contructor
    public Electronics(int id, String name, double price, String brand) {
        super(id, name, (float) price);
        this.brand = brand;
    }

    // getter and setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // override ghi de lai method toStrng
    @Override
    public String toString() {
        return super.toString() + String.format(" | Brand: %s", brand);
    }
}
