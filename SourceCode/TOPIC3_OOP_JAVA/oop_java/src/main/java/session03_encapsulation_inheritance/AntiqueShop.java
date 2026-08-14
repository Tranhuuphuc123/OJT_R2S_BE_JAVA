package session03_encapsulation_inheritance;

import java.util.Scanner;

//class chinh chua menu lenh thuc thi cac khoi ham
public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemlist = new ItemList();
        int choice = 0;

        do {
            System.out.println("\n=== ANTIQUE SHOP MANAGEMENT ===");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by creator");
            System.out.println("6. Display items by type (Vase/Statue/Painting)");
            System.out.println("7. Update item by ID");
            System.out.println("8. Quit");
            System.out.print("Input your choice (1-8): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    Item vase = new Vase();
                    vase.input();
                    if (itemlist.addItem(vase)) {
                        System.out.println("Vase added successfully!");
                    } else {
                        System.out.println("Failed to add Vase! List full.");
                    }
                    break;
                case 2:
                    Item statue = new Statue();
                    statue.input();
                    if (itemlist.addItem(statue)) {
                        System.out.println("Statue added successfully!");
                    } else {
                        System.out.println("Failed to add Statue! List full.");
                    }
                    break;
                case 3:
                    Item painting = new Painting();
                    painting.input();
                    if (itemlist.addItem(painting)) {
                        System.out.println("Painting added successfully!");
                    } else {
                        System.out.println("Failed to add Painting! List full.");
                    }
                    break;
                case 4:
                    itemlist.displayAll();
                    break;
                case 5:
                    System.out.print("Enter creator name to search: ");
                    String creator = sc.nextLine();
                    Item found = itemlist.findItem(creator);
                    if (found != null) {
                        System.out.println("Found item: " + found);
                    } else {
                        System.out.println("No item found for creator: " + creator);
                    }
                    break;
                case 6:
                    System.out.print("Enter type (VASE / STATUE / PAINTING): ");
                    String type = sc.nextLine();
                    itemlist.displayItemsByType(type);
                    break;
                case 7:
                    System.out.print("Enter ID to update: ");
                    String updateId = sc.nextLine();
                    if (itemlist.updateItem(updateId)) {
                        System.out.println("Updated successfully!");
                    } else {
                        System.out.println("Item ID not found!");
                    }
                    break;
                case 8:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose from 1 to 8.");
            }
        } while (choice != 8);
    }
}
