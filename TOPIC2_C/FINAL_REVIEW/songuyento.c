/*tim kiem so nguyen to trong mang*/
#include "array_lib.h"

void songuyento(const int a[], int n){
    int found = 0;
    
    printf("cac so nguyen to trong mang la: \n");
    for(int i = 0; i<n; i++){
        int songuyento = 1;
        if(a[i] < 2){
            songuyento = 0; //khong phai so nguyen to
        }else{
            for(int j = 2; j <= a[i]/2; j++){
                if(a[i] % j == 0){
                    songuyento = 0; //khong phai so nguyen to
                    break;
                }
            }
        }
        if(songuyento){
            printf("%d ", a[i]);
        }
    }
    printf("\n");
}