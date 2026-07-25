/*Exercise 04: Write a program to evaluate the Grade of a student for the following
constraints: 
If marks > 75 – grade A 
If 60 < marks < 75 – grade B 
If 45 < marks<60 – grade C 
If 35 < marks<45 - grade D 
If marks < 35 – grade E */
#include <stdio.h>
int main(){
    int marks;
    char grade;

    printf("Nhap vao diem cua sinh vien: ");
    scanf("%d", &marks);

    if(marks > 75){
        grade = 'A';
    }else if(marks > 60){
        grade = 'B';    
    }else if(marks > 45){
        grade = 'C';
    }else if(marks > 35){
        grade = 'D';
    }else{
        grade = 'E';
    } 

    printf("Diem cua sinh vien la: %d, xep loai: %c\n", marks, grade);
    return 0;
}