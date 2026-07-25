/*Exercise 03: The software allows users to input grades for courses and calculate GPA 
Requirements: 
    • Allow users to input grades for the following courses: database, c, oop, java 
    • Calculate GPA as the average and convert it to a 4-point scale 
    • Conversion from a 10-point scale to a 4-point scale: 
    • GPA = (Grade on a 10-point scale / 10) * 4 
• Examples: 
    • If your grade on a 10-point scale is 10, your GPA will be: (10/10)*4 = 4 
    • If your grade on a 10-point scale is 6.5, your GPA will be: (6.5/10)*4 = 2.6 
    • If your grade on a 10-point scale is 4, your GPA will be: (4/10)*4 = 1.6 
    • Classify GPA based on the following scale: 
    • Excellent: GPA from 3.60 to 4.00 
    • Good: GPA from 3.20 to 3.59 
    • Fair: GPA from 2.50 to 3.19 
    • Average: GPA from 2.00 to 2.49 
    • Weak: GPA below 2.00

    => bai nay la nhap diem cac mon
     + database
     + c
     + oop 
     + java
    => tinh diem trung binh GPA va chuyen doi sang thang diem 4
    theo cong thuc: GPA = (diem thang 10 / 10) * 4
    => phan loai GPA theo thang diem 4:
    + xuat sac: GPA tu 3.60 den 4.00
    + gioi: GPA tu 3.20 den 3.59
    + kha: GPA tu 2.50 den 3.19
    + trung binh: GPA tu 2.00 den 2.49
    + yeu: GPA duoi 2.00
*/
#include <stdio.h>
#include <math.h>

//khai bao ham nguyen mau
float GPA(float diem_data, float diem_c, float diem_oop, float diem_java);
void xep_loai(float diem_gpa);

int main(){

    float diem_data, diem_c, diem_oop, diem_java;

    printf("nhap diem mon database: ");
    scanf("%f", &diem_data);

    printf("nhap diem mon c: ");
    scanf("%f", &diem_c);
      
    printf("nhap diem mon oop: ");
    scanf("%f", &diem_oop);

    printf("nhap diem mon java: ");
    scanf("%f", &diem_java);

    //goi ham tinh diem gpa
    float diem_gpa = GPA(diem_data, diem_c, diem_oop, diem_java);
    printf(" diem GPA cua ban la: %.2f\n", diem_gpa);

    //xep loai hoc sinh qua diem gpa 
    xep_loai(diem_gpa);

}

//ham tinh diem gpa 
float GPA(float diem_data, float diem_c, float diem_oop, float diem_java){
    float diemtrungbinh = (diem_data + diem_c + diem_oop + diem_java) / 4;
    float gpa = (diemtrungbinh / 10) * 4;
    return gpa;
}

//ham xep loai
void xep_loai(float diem_gpa) {
    int loai;

    if (diem_gpa >= 3.60f && diem_gpa <= 4.00f) {
        loai = 4;
    } else if (diem_gpa >= 3.20f) {
        loai = 3;
    } else if (diem_gpa >= 2.50f) {
        loai = 2;
    } else if (diem_gpa >= 2.00f) {
        loai = 1;
    } else {
        loai = 0;
    }

    switch (loai) {
        case 4:
            printf("Xep loai: Xuat sac\n");
            break;
        case 3:
            printf("Xep loai: Gioi\n");
            break;
        case 2:
            printf("Xep loai: Kha\n");
            break;
        case 1:
            printf("Xep loai: Trung binh\n");
            break;
        default:
            printf("Xep loai: Yeu\n");
    }
}