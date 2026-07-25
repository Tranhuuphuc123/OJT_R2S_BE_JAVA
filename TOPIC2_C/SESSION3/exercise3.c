/*Exercise 03: Write a program to generate the Fibonacci series. 
(1,1,2,3,5,8,13,………). 
-> viet chtrinh tao day fibonacci
=> Dãy Fibonacci là một dãy số vô hạn trong toán học, bắt 
đầu bằng 1, 1 (hoặc đôi khi là 0, 1), trong đó mỗi số tiếp
 theo bằng tổng của hai số ngay trước nó.
    + Công thức: F_1 = 1, F_2 = 1, và F_n = F_{n-1} + F_{n-2} (với n >= 3).
    + Ví dụ: 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8,...
*/
#include <stdio.h>
int main(){
    //next dai dien la cong thuc fibanoci Fn
    int n, first = 1, second = 1, next, i;

    printf("Enter the number of terms for Fibonacci series: ");
    scanf("%d", &n);

    printf("Fibonacci Series: ");

    for(i = 1; i <= n; i++){
        // hai phan tu dau luon la 1 nen gang next =1 luon
        if(i == 1 || i == 2){
            next = 1;
        } else {
            // tinh phan tu hien tai bang tong hai phan tu truoc do
            next = first + second;
            /* cap nhat hai bien trượt  de vong sau dung dung 
            hai phan tu lien truoc 
             -> vd 
                i=1: next=1 (in 1)
                i=2: next=1 (in 1)
                i=3: next=2 (in 2) — vì 1+1
                i=4: next=3 (in 3) — vì 1+2
                i=5: next=5 (in 5) — vì 2+3
            */
            first = second;
            second = next;
        }
        printf("%d ", next);
    }

    printf("\n");
    return 0;
}