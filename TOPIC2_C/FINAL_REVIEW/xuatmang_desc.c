#include "array_lib.h"

void sapxepgiamdan(const int arr[], int n, int b[]){
    for (int i = 0; i < n; i++) {
        b[i] = arr[i];
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (b[i] < b[j]) {
                int temp = b[i];
                b[i] = b[j];
                b[j] = temp;
            }
        }
    }
}