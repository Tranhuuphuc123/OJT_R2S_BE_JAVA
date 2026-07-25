/*exercise 4: Write a program to display the following patterns 
 => dung vong lap in ra mang so nhu sau:
 a/  
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5

  b/ 
    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2 
    1  
*/
#include <stdio.h>
int main(){
    int i, j, n;

    printf("Enter the number of rows for the pattern: ");
    scanf("%d", &n);

    // Pattern a
    printf("cau a:\n");
    for(i = 1; i <= n; i++){
        for(j = 1; j <= i; j++){
            printf("%d ", j);
        }
        printf("\n");
    }

    // Pattern b
    printf("cau b:\n");
    for(i = n; i >= 1; i--){
        for(j = 1; j <= i; j++){
            printf("%d ", j);
        }
        printf("\n");
    }

    return 0;
}