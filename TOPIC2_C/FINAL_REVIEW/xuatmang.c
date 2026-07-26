#include "array_lib.h"

void xuatmang(const int arr[], int n){
    printf("\n");
    if (n <= 0) {
        printf("Mang chua co du lieu.\n");
        return;
    }

    printf("****************************** Mang hien tai ******************************:\n");
    for (int i = 0; i < n; i++) {
        printf("arr[%d] = %d\n", i, arr[i]);
    }
    printf("\n");
}