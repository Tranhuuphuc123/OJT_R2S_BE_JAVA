#include "array_lib.h"

int timkiemgiatri(const int a[], int n, int x){
    int count = 0;

    for (int i = 0; i < n; i++) {
        if (a[i] == x) {
            count++;
        }
    }

    return count;
}