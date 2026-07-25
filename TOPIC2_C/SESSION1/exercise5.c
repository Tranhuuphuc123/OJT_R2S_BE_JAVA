/*exercise 5: Exercise 05: Distance Between Two Points 
Write a program to calculate the distance between two points in a two-dimensional 
plane. Prompt the user to enter the coordinates (x1, y1) and (x2, y2) of the two points, 
calculate the distance using the distance formula distance = sqrt((x2 - x1)^2 + (y2 - 
y1)^2), and then display the result.

=> nhap toa do hai diem va tinh khoang cach theo cong thuc*/
#include<stdio.h>
#include<math.h>

int main(){
    int x1, y1, x2, y2;
    double distance;

    printf("Nhap toa do diem thu nhat(x1, y1): ");
    scanf("%d %d", &x1, &y1);

    printf("Nhap toa do diem thu hai(x2, y2): ");
    scanf("%d %d", &x2, &y2);

    //pow: tinh luong mu, sqrt: tinh can bac hai
    distance = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));

    printf("Khoang cach giua hai diem la: sqrt[(%d - %d)^2 + (%d -%d)^2]  = %.2f\n", x2, x1, y2, y1, distance);

    return 0;
}