package session03_encapsulation_inheritance;

import java.util.Scanner;

//class mau cho cho shop ban do co
public class Item {
    // luu y encapsulation ma ke thua thi nen dung protected
    protected String id;
    protected int value;
    protected String creator;

    // contructor
    public Item() {
    }

    public Item(String id, int value, String creator) {
        setId(id);
        setValue(value);
        setCreator(creator);
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id.trim();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be >= 0");
        }
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator == null || creator.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator cannot be empty");
        }
        this.creator = creator.trim();
    }

    /* method nhap */
    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID: ");
            String inputId = sc.nextLine().trim();
            if (!inputId.isEmpty()) {
                this.id = id;
                break;
            }
            System.out.println("Id cannot be empty!");
        }

        while (true) {
            try {
                System.out.println("Enter Value (>=0): ");
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val >= 0) {
                    this.value = val;
                    break;
                }
                System.out.println("Value must be >= 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format!");
            }
        }

        while (true) {
            System.out.println("Enter Creator: ");
            String inputCreator = sc.nextLine().trim();
            if (!inputCreator.isEmpty()) {
                this.creator = inputCreator;
                break;
            }
            System.out.println("Creator cannot be empty!");
        }
    }

    /* method toString */
    @Override
    public String toString() {
        return String.format("ID: %s | Value: %d | Creator: %s ", id, value, creator);
    }

}
