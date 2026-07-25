/* baitap2:Write a C program that accepts the salary and age from the user and
displays the same on the screen as output.
(viet chtrinh nhap luong và tuoi và hiển thị ra màn hình)) */
#include <stdio.h>
int main(){
  float salary;
  int age;

  printf("Enter your salary: ");
  scanf("%f", &salary);
  printf("Enter your age: ");
  scanf("%d", &age);

  //display scene salary and age of user 
  printf("============HIEN THI SALARY AND AGE OF YOU==============");
  printf("\nYour salary is: %.2f", salary);
  printf("\nYour age is: %d", age);

  // return 0: dung de ket thuc chuong trinh va tra ve gia tri 0 cho he dieu hanh
  return 0;
}