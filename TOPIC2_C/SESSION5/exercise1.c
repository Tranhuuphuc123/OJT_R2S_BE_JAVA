/*Exercise 01: Write a program to calculate the area and perimeter of a circle 
=> tinh chu vi dien tich hinh trong 
 c/t tính 
  + dien tich hinh tron: S = PI * r * r
  + chu vi hinh tron: C = 2 * PI * r*/

#include <stdio.h>
#include <math.h>

// hang so pi
#define PI 3.14

//khai bao ham nguyen mau -> bao cho trinh bien dich biet ham nay se duoc dinh nghia o phia sau
float tinh_chuvi(float r);
float tinh_dientich(float r);


int main(){
    float r;

    printf("nhap ban kinh r: ");
    scanf("%f", &r);

    printf("chu vi hinh tron la: P = 2 * %.2f * %.2f = %.2f\n", PI, r, tinh_chuvi(r));
    printf("dien tich hinh tron la: S = %.2f * %.2f * %.2f = %.2f\n", PI, r, r, tinh_dientich(r));

    return 0;
}

//khai bao ham tinh chu vi hinh tron 
float tinh_chuvi(float r){
    return 2 * PI * r;
}

// khai bao ham tinh dien tich hinh tron
float tinh_dientich(float r){
    return PI * r * r;
}
