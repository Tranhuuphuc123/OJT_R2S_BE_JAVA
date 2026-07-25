/*function xuat mang*/
#include "array_lib.h"

void xuatmang(const int arr[], int n){
    //xuat mang
    printf("\n");
    printf("****************************** output mang******************************: \n");
    for(int i =0;i<n; i++){
       printf("arr[%d] = %d\n", i, arr[i]);
    }
    printf("\n");
}