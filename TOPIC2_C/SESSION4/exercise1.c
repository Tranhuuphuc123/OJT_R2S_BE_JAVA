/*Exercise 01: Write a C program to find the minimum and the maximum value in
an array*/
#include <stdio.h>
int main(){
    int n, i, min, max;

    printf("==========NHAP VAO MANG GIA TRI==========\n");
    printf("nhap vao so phan tu cua mang: \n");
    scanf("%d", &n);
    
    int arr[n];
    printf("tien hanh nhap vao tung phan tu cua mang: \n");
    for(i = 0; i<n; i++){
        printf("phan tu thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //tim gia tri nho nhat trong mang 
    min = arr[0];
    for(i = 1; i<n; i++){
        if(arr[i] < min){
            min = arr[i];
        }
    }

    //tim gia tri lon nhat trong mang
    max = arr[0];
    for(i = 1; i<n; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }

    printf("Gia tri nho nhat trong mang la: %d\n", min);
    printf("Gia tri lon nhat trong mang la: %d\n", max);

    return 0;
}