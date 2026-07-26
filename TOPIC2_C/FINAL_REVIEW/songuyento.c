#include "array_lib.h"

static int laSNT(int value){
    if (value < 2) {
        return 0;
    }

    for (int i = 2; i * i <= value; i++) {
        if (value % i == 0) {
            return 0;
        }
    }

    return 1;
}

int lietkesonguyento(const int a[], int n, int result[]){
    int count = 0;

    for (int i = 0; i < n; i++) {
        if (laSNT(a[i])) {
            result[count] = a[i];
            count++;
        }
    }

    return count;
}