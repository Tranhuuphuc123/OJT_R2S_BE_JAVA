/*Develop a program to help users manage 1-D integer number arrays (maximum of 100 
elements) using the following simple menu:: 
    1 - Input the array (1.5 mark) 
    2 - Output the array (0.5 mark) 
    3 - Print out the array in descending order (1 mark) 
    4 - Check if all elements of the array are odd (2 mark) 
    5 - Search a value (2 mark) 
    6 - Displays elements that are prime numbers in the array (2 mark) 
    7 - Quit (1 mark) 
Description: 
    • Create functions for features from 1 to 7 
    • Input the array: Number of elements from 1 to 100 
    • Search a value: Indicates how many times element x appears in the array, with x 
    entered by the user 
    • Quit: Are you sure? Enter 1 to exit the application
    
  => tao mot menu ket hop cac function rieng le voi cac menu sau
   + menu 1: nhap mang
   + menu 2: xuat mang
   + menu 3: xuat mang theo thu tu giam dan
   + menu 4: kiem tra tat ca phan tu trong mang co phai la so le khong
   + menu 5: tim kiem gia tri
   + menu 6: hien thi cac so nguyen to trong mang
   + menu 7: thoat khoi chuong trinh
    */

   #include <stdio.h>
   #include <stdlib.h>
    //luu y: lib tu dinh nghia khong dung dau <> ma dung dau ""
   #include "array_lib.h"


   int main(){
     int arr[MAX]; // Khai báo cố định 100 phần tử
     int n = 0;    // Số lượng phần tử thực tế
     int choice; //bien chon menu

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
        scanf("%d", &choice);

        switch(choice){
            case 1:
                // goi function nhap mang
                nhapmang(arr, &n);
                break;
            case 2:
                // goi function xuat mang
                xuatmang(arr, n);
                break;
            case 3:
                // sap xep mang giam dan
                xuatmang_desc(arr, n);
                break;
            case 4:
                // goi function kiemsole
                kiemchanle(arr, n);
                break;
            case 5:{
                    // goi function tim kiem vi tri x trong mang
                    int x;
                    printf("nhap gia tri x can tim trong mang: ");
                    scanf("%d", &x);
                    timkiemgiatri(arr, n, x);
                    break;
                }
            case 6:
                // cac so nguyen to trong mang
                songuyento(arr, n);
                break;
            case 7:
                // Quit application
                printf("ban co chac chan muon thoat khoi menu khong? neu co vui long nhan 1 xac nhan ");
                int choice;
                scanf("%d", &choice);
                if(choice == 1){
                    exit(0);
                }
                break;
            default:
                printf("Lua chon khong hop le!\n");
        }

     }
     while(1);

     return 0;
   }