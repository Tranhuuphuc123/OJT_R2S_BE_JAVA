/*Hai dòng này được gọi là Include Guard (Lớp bảo vệ đụng độ thư viện). 
#ifndef ARRAY_LIB_H
    + Lắp ghép từ "if not defined" (Nếu chưa được định nghĩa). Trình biên 
    dịch sẽ kiểm tra xem cái nhãn ARRAY_LIB_H đã tồn tại trong bộ nhớ chưa.

#define ARRAY_LIB_H
    + Nếu chưa có, trình biên dịch sẽ tạo/định nghĩa nhãn ARRAY_LIB_H này 
    ngay lập tức và cho phép đọc tiếp các dòng code bên dưới.
*/
#ifndef ARRAY_LIB_H 
#define ARRAY_LIB_H

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX 100

// Khai báo nguyên mẫu các hàm
void nhapmang(int a[], int *n);
void xuatmang(const int a[], int n);
void xuatmang_desc(const int a[], int n);
bool kiemchanle(const int a[], int n);
int timkiemgiatri(const int a[], int n, int x); 
void songuyento(const int a[], int n);

/*#endif (ở cuối file)
Đánh dấu điểm kết thúc của khối bảo vệ.*/
#endif