/*Exercise 06: Write a program to print a multiplication table for a given number 
(number between 2 and 9) 
=> viet chtrinh nhap so in ra bang cuu chuong so do*/

#include <stdio.h>
#include <stdlib.h>

int main(){
    int n, i;

    printf("Enter a number: ");
    scanf("%d", &n);

    for(i =1; i<=10; i++)
    {
        printf("%d * %d = %d\n", n, i, n*i);
    }
    return 0;
}