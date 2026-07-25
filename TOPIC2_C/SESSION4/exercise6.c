/*Exercise 06: Check if all elements of the array are odd 
=> check xem mang nhap co phai tat ca cac phan tu la so le khong*/
#include <stdio.h>
int main(){
    int n, i, count = 0;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    //nhap vao tung phan tu mang 
    for(i = 0; i<n; i++){
        printf("phan tu mang thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //dem so phan tu le trong mang
    for(i = 0; i<n; i++){
        if(arr[i] % 2 != 0){
            count++;
        }
    }

    //kiem tra xem tat ca cac phan tu co phai la so le khong
    if(count == n){
        printf("tat ca cac phan tu trong mang la so le \n");
    }else{
        printf("khong phai tat ca cac phan tu trong mang la so le \n");
    }
}