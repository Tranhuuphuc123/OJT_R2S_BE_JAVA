#include <stdio.h>
#define PI 3.14159

/* bai tap1: tinh chu vi dien tich hinh trong 
 c/t tính 
  + dien tich hinh tron: S = PI * r * r
  + chu vi hinh tron: C = 2 * PI * r
*/
int main(){
  int r;

  // nhap ban kinh hinh tron 
  printf("Nhap ban kinh hinh tron: ");
  scanf("%d", &r);

  // tinh chu vi va dien tich hinh tron
  float chuVi = 2 * PI * r;
  float dienTich = PI * r * r;

  // hien thi ket qua
  printf("Chu vi hinh tron: %.2f\n", chuVi);
  printf("Dien tich hinh tron: %.2f\n", dienTich);

  return 0;
}