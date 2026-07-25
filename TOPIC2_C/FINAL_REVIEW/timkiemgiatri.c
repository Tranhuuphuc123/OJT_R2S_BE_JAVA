/*function tim kiem gia tri trong mang o vi tri nao */
#include "array_lib.h"

int timkiemgiatri(const int a[], int n, int x){

    //tien hanh tim so sanh dk
    for(int i =0; i<n; i++){
        if(a[i] == x){
            printf("tim tay gia tri %d o vi tri thu %d. \n", x, i + 1);
            return i + 1;
        }
    }

    printf("Khong tim thay gia tri %d trong mang.\n", x);
    return -1; // khong tim thay
}