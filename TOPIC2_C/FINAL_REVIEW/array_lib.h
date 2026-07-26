#ifndef ARRAY_LIB_H
#define ARRAY_LIB_H

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX 100

// Khai báo nguyên mẫu các hàm
void nhapmang(int a[], int *n);
void xuatmang(const int a[], int n);
void sapxepgiamdan(const int a[], int n, int b[]);
bool kiemchanle(const int a[], int n);
int timkiemgiatri(const int a[], int n, int x);
int lietkesonguyento(const int a[], int n, int result[]);

#endif