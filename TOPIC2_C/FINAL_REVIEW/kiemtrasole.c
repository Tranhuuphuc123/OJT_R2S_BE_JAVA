/*function kiem tra chan le*/
#include "array_lib.h"

bool kiemchanle(const int a[], int n){
   int count = 0;

   printf("\n") ;
   for(int i =0; i<n; i++){
    if(a[i] % 2 != 0)
    {
        count++;
    }
   }

     //kiem tra xem tat ca cac phan tu co phai la so le khong
    if(count == n){
        printf("tat ca cac phan tu trong mang la so le");
    }else{
        printf("khong phai tat ca cac phan tu trong mang la so le");
    }
}