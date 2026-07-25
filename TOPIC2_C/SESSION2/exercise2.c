/*exercise2:
Write a program to accept 2 numbers. Calculate the difference
between the two values. 
If the difference is equal to any of the values entered, then display the following 
message: Difference is equal to value <number of value entered> 
If the difference is not equal to any of the values entered, display the following 
message: Difference is not equal to any of the values entered

=> nhap hai so tinh hieu va kiem tra coi hieu co bang bat ky gia tri nao da nhap vao khong */

#include <stdio.h>
#include <stdlib.h>

int main(){
    int num1, num2, difference;

    printf("Nhap vao hai so: ");
    scanf("%d %d", &num1, &num2);

    //abs: tinh tuyet doi cua hieu, ||: tri tuyen doi khong am a
    difference = abs(num1 - num2); // tinh hieu tuyet doi

    if(difference == num1){
        printf("Hieu bang gia tri nhap vao: %d\n", num1);
    }else if(difference == num2){
        printf("Hieu bang gia tri nhap vao: %d\n", num2);
    }else{
        printf("Hieu khong bang bat ky gia tri nao da nhap vao\n");
    }

    return 0;
}