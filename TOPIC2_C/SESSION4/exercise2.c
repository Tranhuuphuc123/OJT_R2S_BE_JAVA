/*Exercise 02: Write a program to calculate the sum of odd-valued elements 
in an array
-> viet chtrinh  tinh tong cac so le trong mang*/
#include<stdio.h>
int main(){
    int n, i, sum = 0;

    //tao bien first de danh dau so dau tien trong mang
    int first = 1;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    for(i =0; i<n; i++){
        printf("phan tu mang thu : %d: ", i);
        scanf("%d", &arr[i]);
    }

    //loc tim kiem so le vaf in ra tong cac so le trong mang
   printf("cac so le trong mang la: \n");
   for(i = 0; i< n; i++){
     if(arr[i] % 2 != 0){
        if(!first){
            printf(" + ");
        }
        printf("%d", arr[i]);
        sum += arr[i];

        //danh dau so le dau tien trong mang
        first = 0;
     }
   }
   printf(" = %d\n", sum);
   return 0;
}