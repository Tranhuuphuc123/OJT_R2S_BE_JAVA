/*Exercise 05: Write a program to generate the following pattern
 => in ra dau *
    * * * * *
    * * * *
    * * *
    * *
    * 
*/
#include <stdio.h>
int main(){
    int i, j, n;

    printf("Entrr the number of rows for the pattern: ");
    scanf("%d", &n);

    for (i = n; i>=1; i--){
        for (j =1; j<= i; j++){
            printf("* ");
        }
        printf("\n");
    }
}