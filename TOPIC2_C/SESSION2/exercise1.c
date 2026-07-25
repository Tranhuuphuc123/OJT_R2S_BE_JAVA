/*exercise1: Write a program to accept 2 numbers and tell whether the
product of the two numbers is equal to or greater than 1000.
=> viet chtrinh nhap hai so kiem tra coi tich do co lon hon hay bang 
1000 khong*/
#include <stdio.h>
#include <math.h>

int main(){
    int num1, num2, product;

    printf("Nhap vao hai so: ");
    scanf("%d %d", &num1, &num2);

    product = num1 * num2;

    if(product >= 1000){
        printf("Tich cua hai so la: %d >= 1000\n", product);
    }else{
        printf("Tich cua hai so la: %d < 1000\n", product);
    }

    return 0;
}