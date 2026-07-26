#include "array_lib.h"

void nhapmang(int arr[], int *n){
    int size;

    do {
        printf("Nhap so phan tu cua mang (1 -> %d): ", MAX);
        if (scanf("%d", &size) != 1) {
            printf("Du lieu khong hop le.\n");
            return;
        }

        if (size < 1 || size > MAX) {
            printf("So phan tu khong hop le. Vui long nhap lai.\n");
        }
    } while (size < 1 || size > MAX);

    *n = size;

    printf("==========Nhap tung gia tri mang==========\n");
    for (int i = 0; i < *n; i++) {
        printf("Phan tu thu %d: ", i);
        scanf("%d", &arr[i]);
    }
}