package session04_polymorphism_abstraction;

import java.util.Scanner;

public class Program {
    private Product[] listPro;
    private byte count;
    private static final byte MAX = 100;

    // dinh nghia cac tham so menu
    private static final byte ADD = 1;
    private static final byte DISPLAY = 2;
    private static final byte FIND = 3;
    private static final byte EXIT = 0;

    // contructor
    public Program() {
        listPro = new Product[MAX];
        count = 0;
    }

    // hàm main chinh chua menu
    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice = -1;

        do {
            System.out.println("\n=== E-COMMERCE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Product");
            System.out.println("2. Display listPro");
            System.out.println("3. Find Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Byte.parseByte(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case ADD:
                    System.out.print("Choose product type (1: Electronics, 2: Clothing): ");
                    byte type = Byte.parseByte(scanner.nextLine().trim());

                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine().trim());

                    if (type == 1) {
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine().trim();
                        p.addProduct(new Electronics(id, name, price, brand));
                    } else if (type == 2) {
                        System.out.print("Enter Size: ");
                        String size = scanner.nextLine().trim();
                        p.addProduct(new Clothing(id, name, price, size));
                    } else {
                        System.out.println("Invalid product type!");
                    }
                    break;

                case DISPLAY:
                    p.displaylistPro();
                    break;

                case FIND:
                    System.out.print("Enter Product ID to find: ");
                    int findId = Integer.parseInt(scanner.nextLine().trim());
                    Product found = p.findProduct(findId);
                    if (found != null) {
                        System.out.println("Product Found: " + found);
                    } else {
                        System.out.println("Product with ID " + findId + " not found!");
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != EXIT);

        scanner.close();
    }

    /* cac metho phu tro */
    public void addProduct(Product product) {
        if (count >= MAX) {
            System.out.println("Cannot add product. Inventory is full!");
            return;
        }
        listPro[count++] = product;
        System.out.println("Product added successfully.");
    }

    public void displaylistPro() {
        if (count == 0) {
            System.out.println("No listPro available.");
            return;
        }
        System.out.println("\n--- PRODUCT LIST ---");
        for (int i = 0; i < count; i++) {
            System.out.println(listPro[i]);
        }
    }

    public Product findProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (listPro[i].getId() == id) {
                return listPro[i];
            }
        }
        return null;
    }

}
