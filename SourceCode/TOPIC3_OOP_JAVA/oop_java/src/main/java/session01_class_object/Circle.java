package session01_class_object;

public class Circle {
    private double radius;
    final double PI = 3.14;

    // contructor
    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    // getter and setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    // method getArean hien thi dien tich hinh tron
    public double getArean() {
        return Math.PI * Math.pow(this.radius, (double) 2.0F);
    }

}
