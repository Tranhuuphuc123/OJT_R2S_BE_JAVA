import java.util.Scanner;

public class Painting extends Item {
    private int height; // height>=0 and height <=2000
    private int width; // width >=0 and <= 3000
    private boolean isWaterColor; // not empty
    private boolean isFramed; // not empty

    // contructors
    public Painting() {
        super();
        this.height = 0;
        this.width = 0;
        this.isWaterColor = false;
        this.isFramed = false;
    }

    public Painting(String id, int value, String creator,
            int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        setWaterColor(isWaterColor);
        setFramed(isFramed);
    }

    // getter and setter
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 0 && height <= 2000) {
            this.height = height;
        } else {
            System.out.println("Height must be between 0 and 2000!");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width >= 0 && width <= 3000) {
            this.width = width;
        } else {
            System.out.println("Width must be between 0 and 3000!");
        }
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean isWaterColor) {
        this.isWaterColor = isWaterColor; // gan truc tiep kieu boolean
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    /* method input */
    @Override
    public void input() {
        // Nhập thuộc tính của Item trước
        super.input();

        Scanner sc = new Scanner(System.in);

        // Nhập height có kiểm tra điều kiện
        do {
            System.out.print("Enter height (0 <= height <= 2000): ");
            this.height = sc.nextInt();
        } while (this.height < 0 || this.height > 2000);

        // Nhập width có kiểm tra điều kiện
        do {
            System.out.print("Enter width (0 <= width <= 3000): ");
            this.width = sc.nextInt();
        } while (this.width < 0 || this.width > 3000);

        // Nhập kiểu boolean
        System.out.print("Is it watercolor? (true/false): ");
        this.isWaterColor = sc.nextBoolean();

        System.out.print("Is it framed? (true/false): ");
        this.isFramed = sc.nextBoolean();
    }

    /* method toString */
    @Override
    public String toString() {
        return super.toString() + ", Height: " + height +
                ", Width: " + width +
                ", WaterColor: " + isWaterColor +
                ", Framed: " + isFramed;
    }
}
