/* baitap3: Write a program to evaluate the net salary of an employee given the 
following constraints: 
Basic salary : $ 12000 
DA : 12% of Basic salary 
HRA : $150 
TA : $120 
Others : $450 
Tax cuts – a) PF :14% of Basic salary and b) IT: 15% of Basic salary 
Net Salary = Basic Salary + DA + HRA + TA + Others – (PF + IT)
 => yeu cau tu thong tin ve luong cua mot nhaan vien, tinh luong thuc the 
 thuc nhan va in ra thong tin
*/
#include <stdio.h>
int main(){
    // phan khai bao thong tin luong cung 
    float basicSalary = 12000;
    float HRA = 150;
    float TA = 120;
    float Others = 450;

    // phan tinh phu cap phan tram tren luong co ban 
    float DA = (12 * basicSalary)/ 100;
    float PF = (14 * 12000)/100;
    float IT = (15 * 12000)/100;

    // tinh toan luong thuc nhan 
    float netSalary = basicSalary + DA + HRA + TA + Others - (PF + IT);

    // DISPLAY THONG TIN PHIEU NHAN LUONG 
    printf("============PHIEU NHAN LUONG==============");
    printf("\nBasic Salary: %.2f", basicSalary);
    printf("\nDA: %.2f", DA);   
    printf("\nHRA: %.2f", HRA);
    printf("\nTA: %.2f", TA);
    printf("\nOthers: %.2f", Others);
    printf("\nPF: %.2f", PF);
    printf("\nIT: %.2f", IT);

    printf("\n==========Luong thuc nhan============");
    printf("\nNet Salary: %.2f USD", netSalary);
    printf("\n=====================================");
    return 0;
}