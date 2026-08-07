import java.util.Scanner;

public class Item {
    // declare properties
    protected String id; // not null and unique(khong bi trung)
    protected int value; // price of a item >=0
    protected String creator; // not empty

    // contructor 1: default
    public Item() {
    }

    // contructor 2: have parameters
    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            System.out.println("Error. Value must be greater than 0");
        }
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator != null && !creator.isEmpty()) {
            this.creator = creator;
        } else {
            System.out.println("Error: Creator Name cannot be empty");
        }
    }

    /* method ca nhan */
    public void input() {
        Scanner sc = new Scanner(System.in);

        // nhap id(khong dc rong)
        do {
            System.out.println("Enter ID: ");
            this.id = sc.nextLine().trim();
            if (this.id.isEmpty()) {
                System.out.println("ID cannot be emtpy. Please try again");
            }
        } while (this.id.isEmpty());

        // nhap value (phai >= 0)
        do {
            try {
                System.out.println("Enter value(>=0): ");
                this.value = Integer.parseInt(sc.nextLine().trim());
                if (this.value < 0) {
                    System.out.println("Value must be >=0. Please try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalie number! Please enter an integer ");
                this.value = -1;
            }
        } while (this.value < 0);

        // nhap creator
        do {
            System.out.println("Enter Creator: ");
            this.creator = sc.nextLine().trim();
            if (this.creator.isEmpty()) {
                System.out.println("Creator cannot be empty. Please try again");
            }
        } while (this.creator.isEmpty());
    }

    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }

}