/*Exercise 02: Write a program to calculate the factorial of an integer
-> viet ham tinh giai thua cua so nguyen 
=> giai thua la tich cua tat ca cac so nguyen duong tu 1 den n
 + vd: 5! = 1 * 2 * 3 * 4 * 5 = 120*/

 #include <stdio.h>
 #include <math.h>

 //khai bao ham nguyen mau 
 int tinh_giaithua(int n);

 int main(){
    int n;

    printf(" nhap vao so nguyen to n: ");
    scanf("%d", &n);

    // Kiểm tra điều kiện n phải >= 0
    if (n < 0) {
        printf("Loi: Khong tinh duoc giai thua cua so am!\n");
        return 1;
    }

    // Trường hợp n = 0
    if (n == 0) {
        printf("Giai thua cua 0 la: 0! = 1\n");
        return 0;
    }

    printf("giai thua cua so nguyen to %d! la: ", n);
    for(int i = 1; i<=n; i++){
        printf("%d", i);
        if(i<n){
            printf(" * ");
        }
    }
    printf(" = %d", tinh_giaithua(n));

    return 0;
 }

 //function tinh giai thua 
 int tinh_giaithua(int n){
    int gt = 1;
    for(int i = 1; i<=n; i++){
        gt *= i;
    }
    return gt;
 }