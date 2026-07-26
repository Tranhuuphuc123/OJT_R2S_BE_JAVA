#include <stdio.h>
#include <stdlib.h>
#include "array_lib.h"

int main(void){
    int arr[MAX];
    int sortedArr[MAX];
    int n = 0;
    int choice;

    do{
        printf("================MENU CHUONG TRINH=================\n");
        printf("1. Nhap mang\n");
        printf("2. Xuat mang\n");
        printf("3. Xuat mang theo thu tu giam dan\n");
        printf("4. Kiem tra tat ca phan tu la so le\n");
        printf("5. Tim kiem gia tri\n");
        printf("6. Hien thi cac so nguyen to trong mang\n");
        printf("7. Thoat khoi chuong trinh\n");
        printf("===============================================\n");

        printf("Chon mot lua chon: ");
        if (scanf("%d", &choice) != 1) {
            printf("Du lieu khong hop le.\n");
            return 1;
        }

        switch(choice){
            case 1:
                nhapmang(arr, &n);
                break;
            case 2:
                xuatmang(arr, n);
                break;
            case 3:
                if (n <= 0) {
                    printf("Mang chua duoc nhap.\n");
                } else {
                    sapxepgiamdan(arr, n, sortedArr);
                    xuatmang(sortedArr, n);
                }
                break;
            case 4:
                if (kiemchanle(arr, n)) {
                    printf("Tat ca cac phan tu trong mang la so le.\n");
                } else {
                    printf("Khong phai tat ca cac phan tu trong mang la so le.\n");
                }
                break;
            case 5:{
                int x;
                int count;
                printf("Nhap gia tri x can tim trong mang: ");
                scanf("%d", &x);
                count = timkiemgiatri(arr, n, x);
                if (count > 0) {
                    printf("Gia tri %d xuat hien %d lan trong mang.\n", x, count);
                } else {
                    printf("Khong tim thay gia tri %d trong mang.\n", x);
                }
                break;
            }
            case 6:{
                int primeArr[MAX];
                int count;

                count = lietkesonguyento(arr, n, primeArr);
                if (count == 0) {
                    printf("Khong co so nguyen to trong mang.\n");
                } else {
                    printf("Cac so nguyen to trong mang la: ");
                    for (int i = 0; i < count; i++) {
                        printf("%d ", primeArr[i]);
                    }
                    printf("\n");
                }
                break;
            }
            case 7:{
                int confirm;
                printf("Ban co chac chan muon thoat? Nhap 1 de xac nhan: ");
                scanf("%d", &confirm);
                if (confirm == 1) {
                    printf("Tam biet!\n");
                    return 0;
                }
                break;
            }
            default:
                printf("Lua chon khong hop le!\n");
        }

    } while (1);

    return 0;
}