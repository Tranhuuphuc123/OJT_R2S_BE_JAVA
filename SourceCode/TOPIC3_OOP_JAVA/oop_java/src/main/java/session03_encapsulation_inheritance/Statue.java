package session03_encapsulation_inheritance;

import java.util.Scanner;

//class tuong: ke thua item la mot trong cac mon do co
public class Statue extends Item {
    private int weight;
    private String color;
    private Scanner sc;

    // contructor
    public Statue() {
        super();
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
        this.sc = new Scanner(System.in);
    }

    // getter and setter
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 0 || weight > 1000) {
            throw new IllegalArgumentException("Weight must be between 0 and 1000");
        }
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty! ");
        }
        this.color = color.trim();
    }

    // method input
    @Override
    public void input() {
        super.input();
        while (true) {
            try {
                System.out.println("Enter weight (0-1000): ");
                int w = Integer.parseInt(sc.nextLine().trim());
                if (w >= 0 && w <= 1000) {
                    this.weight = w;
                    break;
                }
                System.out.println("Weight must be between 0 and 1000");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format!");
            }
        }

        while (true) {
            System.out.println("Enter color: ");
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                this.color = value;
                break;
            }
            System.out.println("Color cannot be empty!");
        }
    }

    // method toString
    @Override
    public String toString() {
        return super.toString() + String.format(", Weight: %d | Color: %s", weight, color);
    }

}
