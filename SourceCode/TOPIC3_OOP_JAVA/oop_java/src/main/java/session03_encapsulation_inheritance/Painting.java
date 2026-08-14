package session03_encapsulation_inheritance;

import java.util.Scanner;

//class tranh ve ke thua item: mot trong cac mon do co cua cua hang
public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {
        super();
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor,
            boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000)
            throw new IllegalArgumentException("Height in [0, 2000]");
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width < 0 || width > 3000)
            throw new IllegalArgumentException("Width in [0, 3000]");
        this.width = width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean isWaterColor) {
        this.isWaterColor = isWaterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter Height (0-2000): ");
                int h = Integer.parseInt(sc.nextLine().trim());
                if (h >= 0 && h <= 2000) {
                    this.height = h;
                    break;
                }
                System.out.println("Height must be between 0 and 2000!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Width (0-3000): ");
                int w = Integer.parseInt(sc.nextLine().trim());
                if (w >= 0 && w <= 3000) {
                    this.width = w;
                    break;
                }
                System.out.println("Width must be between 0 and 3000!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!");
            }
        }

        System.out.print("Is Water Color? (true/false): ");
        this.isWaterColor = Boolean.parseBoolean(sc.nextLine().trim());

        System.out.print("Is Framed? (true/false): ");
        this.isFramed = Boolean.parseBoolean(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d, Width: %d, WaterColor: %b, Framed: %b", height, width,
                isWaterColor, isFramed);
    }
}
