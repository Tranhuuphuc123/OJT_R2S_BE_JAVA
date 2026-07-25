/*Exercise 5: Write a program to show your computer’s capabilities. The user types in
a letter of the alphabet and your program should display the corresponding language
or package available. Some sample input and output is given below : 

        Input                        Output
        -----------------------------------
        B or b                        Basic
        C or c                        Cobol
        f or F                        Fortran
        p or P                        Pascal
        V or V                        Visual C+*/
#include <stdio.h>        
int main(){
    char input;
    printf("Nhap vao mot chu cai: ");
    scanf(" %c", &input); // space before %c to consume any leftover whitespace

    switch(input){
        case 'B':
        case 'b':
            printf("Basic\n");
            break;
        case 'C':
        case 'c':
            printf("Cobol\n");
            break;
        case 'F':
        case 'f':
            printf("Fortran\n");
            break;
        case 'P':
        case 'p':
            printf("Pascal\n");
            break;
        case 'V':
        case 'v':
            printf("Visual C+\n");
            break;
        default:
            printf("Khong co ngon ngu hoac goi goi phu hop cho chu cai da nhap.\n");
            break;
    }

    return 0;
}