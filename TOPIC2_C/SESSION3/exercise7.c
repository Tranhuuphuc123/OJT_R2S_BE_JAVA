/*Exercise 07: Write a program to check if the user-entered password is valid or not? 
Knowing that the valid password is 12345. Each time the user enters incorrectly, the 
program will display 'Invalid password' and allow the user to re-enter. The program 
will end if the user enters the correct password or exceeds 3 incorrect attempts.

=> viet chtrinh ung dung nhap mat khau
=> mat khau mat dinh la 12345
=> neu nguoi dung nhap dung thi hoac sai khong qua 3 lan 
neu nhap dung thong bao va dung chtrinh neu nhap sai  
thi cung thong bao va dung chtrinh*/

#include <stdio.h>
int main(){
    //attempts de dem so lan nguoi dung nhap sai mat khau
    int password, attempts = 0;

    //tao hang so mac dinh password la 12345
    const int valid_password = 12345;

    while(attempts <= 3){
        printf("Enter password: ");
        scanf("%d", &password);

        if(password == valid_password){
            printf("Valid password. Access granted.\n");
            break;
        } else {
            attempts++;
            printf("Invalid password. Please try again.\n");
        }
    }

    if(attempts > 3){
        printf("Too many incorrect attempts. Access denied.\n");
    }

    return 0;
}