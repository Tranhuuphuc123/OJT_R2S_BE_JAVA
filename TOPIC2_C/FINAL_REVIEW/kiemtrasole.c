#include "array_lib.h"

bool kiemchanle(const int a[], int n){
    if (n <= 0) {
        return false;
    }

    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            return false;
        }
    }

    return true;
}