/*function nhap mang*/
#include "array_lib.h"

void nhapmang(int arr[], int *n){
    printf("nhap so n mang: ");
    scanf("%d", n);

    //nhap tung gia tri mang
    printf("==========nhap tung gia tri mang============ \n");
    for(int i=0; i<*n; i++){
        printf("phan tu thu arr[%d]", i);
        scanf("%d", &arr[i]);
    }
}