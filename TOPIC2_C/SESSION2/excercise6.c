/*Excercise6:Quadratic Equation Solver 
Write a program that solves a quadratic equation of the form ax^2 + bx + c = 0. 
Prompt the user to enter values for coefficients a, b, and c. Calculate the 
discriminant (delta) using the formula delta = b^2 - 4ac. If delta is positive, calculate 
and display the roots of the equation using the quadratic formula. If delta is zero or 
negative, display an appropriate message. 

** tinh phuong trinh bac hai**
=> p/t bac hai: ax^2 + bx + c = 0
=> delta = b^2 - 4ac
 + neu delta >0: co 2 nghiem phan biet
 + neu delta =0: co 1 nghiem kep
 + neu delta <0: khong co nghiem thuc*/
 
#include <stdio.h>
#include <math.h>
int main(){
    double a, b, c, delta, root1, root2;

    printf("Nhap vao he so a, b, c cua phuong trinh bac hai (ax^2 + bx + c = 0): ");
    scanf("%lf %lf %lf", &a, &b, &c);

    delta = b * b - 4 * a * c; // tinh delta

    if(delta > 0){
        root1 = (-b + sqrt(delta)) / (2 * a);
        root2 = (-b - sqrt(delta)) / (2 * a);
        printf("Phuong trinh co hai nghiem phan biet: x1 = %.2lf, x2 = %.2lf\n", root1, root2);
    }else if(delta == 0){
        root1 = -b / (2 * a);
        printf("Phuong trinh co nghiem kep: x = %.2lf\n", root1);
    }else{
        printf("Phuong trinh khong co nghiem thuc.\n");
    }

    return 0;
}