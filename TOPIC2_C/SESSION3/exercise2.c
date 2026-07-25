/*Exercise 02: Accept two numbers num1 and num2. Find the sum of all odd numbers 
between the two numbers entered.
=> nhap hai so va tinh tong cac so le nam giua hai so do */
#include <stdio.h>

int main(){
    int num1, num2, sum = 0, i;

    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);

    // thuc hien hoan doi gia tri neu num1 > num2
    if(num1 > num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }

    for(i = num1; i <= num2; i++){
        if(i % 2 != 0){
            sum += i;
        }
    }

    printf("Sum of odd numbers between %d and %d is %d\n", num1, num2, sum);
    return 0;
}