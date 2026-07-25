/* exercise 4: Sum of Digits 
Write a program that calculates the sum of digits of a three-digit number. Declare 
variables num, digit1, digit2, and digit3. Prompt the user to enter a three-digit number, 
extract each digit using division and modulo operations, calculate the sum of digits, 
and then display the result.
 => tính tổng các chữ số có 3 chữ số, nghĩa là nhập vào số mà có b chữ số tách chúng ra 
 thành từng số riêng lẻ và tính tổng chúng cộng lại 
 => bai toan nay meo la dung phep % phep chia lay du va
 dung phep chia het de tach so
  + vd: / 10 100 thi lay phan chia dc khong lay phan du
        %10 chia lay phan du */

#include <stdio.h>
int main(){
    int digit1, digit2, digit3, total, num;

    printf("Vui long nhap vao mot sos co 3 chu so: ");
    scanf("%d", &num);

    digit1 = num / 100; // lay chu so hang tram
    digit2 = (num / 10) % 10; // lay chu so hang chuc
    digit3 = num % 10; // lay chu so hang don vi

    total = digit1 + digit2 + digit3;
    printf("Tong cac chu so la: %d + %d +%d = %d\n", digit1, digit2, digit3, total);

    return 0;
}