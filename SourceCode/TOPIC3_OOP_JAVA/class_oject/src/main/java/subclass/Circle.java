/*lab 01: class nay chua method tra ve tinh toan dien tich hinh tron
 => dien tich hinh tron la:
  dien tich circle = pi. r^2
*/
package subclass;

public class Circle{
    //properties 
    public double radius;
    final double PI = 3.14;

    //method tra ve dien tich hinh trong
    public double CircleArea(){
        return PI * Math.pow(radius, 2);
    }
}