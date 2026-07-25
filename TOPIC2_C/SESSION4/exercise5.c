/*Exercise 05: Indicates how many elements in the array have values less than 0
 => nhap mang va in ra cac so nho hon khong  rong mang
*/
#include <stdio.h>
int main(){
    int n, i, count =0;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    //nhap vao tung phan tu mang 
    for(i = 0; i<n; i++){
        printf("phan tu mang thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //dem so phan tu mang nho hon khong va in ra cac phan tu do
    printf("cac phan tu nho hon khong la: ");
    for(i = 0; i<n; i++){
        if(arr[i] < 0){
            printf("%d ", arr[i]);
            count++;
        }
    }
    printf("\n");
    printf("\n tong cac phan tu nho hon khong la:  %d", count);
    return 0;
}