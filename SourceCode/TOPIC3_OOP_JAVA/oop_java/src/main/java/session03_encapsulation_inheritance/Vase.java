package session03_encapsulation_inheritance;

import java.util.Scanner;

//class binh hoa: mot trong cac mon do co ke thua tu item
public class Vase extends Item {
    private int height;
    private String material;

    // contructor
    public Vase() {
        super();
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        setHeight(height);
        setMaterial(material);
    }

    // getter and setter
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000) {
            /*
             * IllegalArgumentException: exception bat loi khi phuong thuc dau
             * vao khong khop voi du lieu rang buoc da thiet lap
             */
            throw new IllegalArgumentException("Height must be 0-2000");
        }
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material cannot be empty");
        }
        this.material = material.trim();
    }

    /* method nhap lieu */
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter height (0 - 2000): ");
                int height = Integer.parseInt(sc.nextLine().trim());
                if (height >= 0 && height <= 2000) {
                    this.height = height;
                    break;
                }
                System.out.println("Height must be between 0 and 2000");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }

        while (true) {
            System.out.println("Enter material: ");
            String mat = sc.nextLine().trim();
            if (!mat.isEmpty()) {
                this.material = material;
                break;
            }
            System.out.println("Material cannot be empty!");
        }
    }

    // method toStrng
    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d | Material: %s", height, material);
    }

}
