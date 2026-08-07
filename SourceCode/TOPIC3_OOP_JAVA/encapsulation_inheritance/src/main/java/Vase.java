import java.util.Scanner;

public class Vase extends Item {
    private int height; // height of vase(>= 0 and <= 200)
    private String material; // material of vase(is not empty)

    // contructor
    public Vase() {
        super();
    }

    public Vase(String id, int value, String creator, int height, String material) {
        // tu khoa super giup ke thua cac thuoc tinh tu Item class
        super(id, value, creator);
        setHeight(height);
        setMaterial(material);
    }

    // getter and setter
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0 && height <= 200) {
            this.height = height;
        } else {
            System.out.println("Error: The height falls within the range of 0 to 200");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material != null && !material.trim().isEmpty()) {
            this.material = material.trim();
        } else {
            System.out.println("Error. Material cannot be empty");
        }
    }

    /* method Input */
    @Override
    public void input() {
        // 1. nhap thong tin thuoc tinh lop cha item class(id, value, creator)
        super.input();

        Scanner sc = new Scanner(System.in);

        // nhap height
        do {
            try {
                System.out.println("Enter height: ");
                this.height = Integer.parseInt(sc.nextLine().trim());
                if (height < 0 || height > 200) {
                    System.out.println(
                            "Error. height must be greater than 0 (> 0) and less than or equal to 200(<= 200) ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalie number! Please enter an integer");
                this.height = -1; // Gán giá trị vi phạm để tiếp tục vòng lặp
            }
        } while (this.height < 0 || this.height > 200);

        // nhap material
        do {
            System.out.println("Enter Material: ");
            this.material = sc.nextLine().trim();
            if (this.material.isEmpty()) {
                System.out.println("Error. material cannot be empty");
            }
        } while (this.material.isEmpty());
    }

    /* method toString */
    public String toString() {
        // ke thua super method toString tu item class
        return super.toString() + String.format("Height: %d, Material: %s, Creator: %s", height, material);
    }

}