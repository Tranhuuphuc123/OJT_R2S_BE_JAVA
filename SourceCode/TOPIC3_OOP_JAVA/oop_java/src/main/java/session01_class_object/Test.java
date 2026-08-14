package session01_class_object;

public class Test {
    public static void main(String[] args) {
        // khoi tao class circle
        Circle circle = new Circle();
        circle.setRadius(12);
        System.out.println(String.format("Area of the Circle: %.2f ", circle.getArean()));
    }
}
