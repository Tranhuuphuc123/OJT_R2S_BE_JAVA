import java.util.Scanner;

public class Statue extends Item {
    private int weight; // 0=<weight <= 1000
    private String color; // color is not empty

    // contructor
    public Statue() {
        super();
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
    }

    // getter and setter
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 1000) {
            this.weight = weight;
        } else {
            System.out.println(
                    "Error. The weight must be greater than or equal to 0 and less than or equal 1000( 0 <= weight <=1000) ");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        } else {
            System.out.println("Error. color cannot be empty");
        }
    }

    /** METHOD **/
    @Override
    public void input() {
        // 1. nhap thong tin thuoc tinh lop cha item class(id, value, creator)
        super.input();

        Scanner sc = new Scanner(System.in);

        // 2. nhap weight
        do {
            try {
                System.out.println("Enter the weight: ");
                this.weight = Integer.parseInt(sc.nextLine().trim());
                if (this.weight < 0 || this.weight > 1000) {
                    System.out.println(
                            "Error. The weight must be greater than or equal to 0 and less than or equal 1000( 0 <= weight <=1000) ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalie number! Please enter an integer");
                this.weight = -1; // Gán giá trị vi phạm để tiếp tục vòng lặp
            }
        } while (this.weight < 0 || this.weight > 1000);

        // nhap color
        do {
            System.out.println("Enter color: ");
            this.color = sc.nextLine().trim();
            if (this.color.trim().isEmpty()) {
                System.out.println("Error. The color cannot be empty");
            }
        } while (this.color.isEmpty());
    }

    /* method toString */
    public String toString() {
        // ke thua super method toString tu item class
        return super.toString() + String.format("Weight: %s, Color: %d", weight, color);
    }
}