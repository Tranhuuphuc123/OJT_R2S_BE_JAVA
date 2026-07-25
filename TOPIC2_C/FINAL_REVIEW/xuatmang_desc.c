/*xuatmang_giamdan*/
#include "array_lib.h"

void xuatmang_desc(const int arr[], int n){
   // 1. Sao chep sang mang tam de khong lam thay doi mang goc
    int temp_arr[MAX];
    for (int i = 0; i < n; i++) {
        temp_arr[i] = arr[i];
    }

    // 2. Sap xep giam dan (Dung thuat toan Doi cho truc tiep - Interchange Sort)
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (temp_arr[i] < temp_arr[j]) {
                //su dung ky  thuat swap hoan vi doi cho
                int temp = temp_arr[i];
                temp_arr[i] = temp_arr[j];
                temp_arr[j] = temp;
            }
        }
    }

    //xuat mang
    printf("\n");
    printf("****************************** output mang _ desc******************************: \n");
    for(int i =0;i<n; i++){
       printf("arr[%d] = %d\n", i, temp_arr[i]);
    }
    printf("\n");
}