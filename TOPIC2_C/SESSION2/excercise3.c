/*exercise3: cong ty abc tra luong nhan vien + phu cap theo cap bac
 + A: phu cap 300 usd 
 + B: phu cap 200 usd 
 + other: 100 usd 

 => viet chtrinh nhap vao luong nhan vien va cap bac cua nhan vien roi
  tinh luong thuc nhan cua nhan vien do
 */
#include <stdio.h>
int main(){
    float salary, phucap, total_salary;
    char capbac;

    printf("Nhap vao luong nhan vien: ");
    scanf("%f", &salary);

    printf("Nhap vao cap bac cua nhan vien (A, B, C): ");
    scanf(" %c", &capbac); // space before %c to consume any leftover whitespace

    switch(capbac){
        case 'A':
            phucap = 300.0;
            break;
        case 'B':
            phucap = 200.0;
            break;
        default:
            phucap = 100.0;
            break;
    }

    total_salary = salary + phucap;

    printf("Luong thuc nhan cua nhan vien la: %.2f + %.2f = %.2f\n", salary, phucap, total_salary);

    return 0;
}