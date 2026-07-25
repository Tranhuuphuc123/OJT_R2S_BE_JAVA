/* exercise1: Write a program to print the series 100, 95 , 90, 85,………., 5. */
#include <stdio.h>
int main(){
    int i;
    printf("Series: ");
    for(i = 100; i >= 5; i -= 5){
        printf("%d ", i);
    }
    printf("\n");
    return 0;
}