/*Exercise 06: Triangle Area Calculation 
Write a program to calculate the area of a triangle given the lengths of its three sides. 
Prompt the user to enter the lengths of the three sides, calculate the semi-perimeter (s) 
using the formula s = (a + b + c) / 2, and then calculate the area using Heron's formula 
area = sqrt(s * (s - a) * (s - b) * (s - c)), where a, b, and c are the lengths of the sides

=> bai nay la tinh dien tich tam giac khi biet chieu dai ba canh
 + dien tich tam giac la: s = 1/2 * a * b  
 <=> neu chi biet chieu dai ba canh ma khong co chieu cao thi ap dung 
 cong thuc heron laf tinh nua chu vi: p = (a + b + c) / 2 
 ==> s tam giac: area = sqrt(p * (p - a) * (p - b) * (p - c))*/
 #include <stdio.h>
#include <math.h>

int main(){
    double a, b, c, s , area;
    printf("Nhap vao do dai ba canh cua tam giac: ");
    scanf("%lf %lf %lf", &a, &b, &c);

    s = (a + b + c) / 2; // tinh nua chu vi
    area = sqrt(s * (s - a) * (s - b) * (s - c)); // tinh dien tich tam giac theo cong thuc heron

    printf("Dien tich cua tam giac la: %.2lf\n", area);
    return 0;
}