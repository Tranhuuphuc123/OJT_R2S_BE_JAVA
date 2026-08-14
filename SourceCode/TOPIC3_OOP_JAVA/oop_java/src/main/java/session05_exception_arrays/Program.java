package session05_exception_arrays;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=== Product Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // NumberFormatException: nem ra khi chuoi chuyen sang so bi loi
                /*
                 * choice -1: khong hop le, can bat lai, -1 la bao trang thai sai
                 * khi khong chon case nao tu 1-4 no se roi vao t/h default bao sai
                 * va bat nhap lai
                 */
                choice = -1;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter product details:");
                        System.out.print("Product ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Product Name: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Product Price: ");
                        double price = Double.parseDouble(scanner.nextLine().trim());

                        System.out.print("Quantity in Stock: ");
                        int qty = Integer.parseInt(scanner.nextLine().trim());

                        Product p = new Product(id, name, price, qty);
                        pm.addProduct(p);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input format!");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Product ID to retrieve: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        Product found = pm.getProductByID(id);
                        found.displayProductInfo();
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format!");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Enter new quantity: ");
                        int newQty = Integer.parseInt(scanner.nextLine().trim());

                        pm.updateProductQuantity(id, newQty);
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option! Please choose 1 - 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
