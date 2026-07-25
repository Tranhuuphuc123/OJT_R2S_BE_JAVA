/*exercise 04: Displays elements whose values are divisible by 3 or 5. 
 => nhap vao mang cac gia tri va in ra cac phan tu 
 chia het cho 3 or 5
*/
#include <stdio.h>
int main(){
    int n, i;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    //nhap tung phan tu vao mang    
    for(i =0; i<n; i++){
        printf("phan tu mang thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //in ra cac phan tu chia het cho 3 or 5
    printf("cac phan tu chia het cho 3 or 5 la: ");
    for(i =0; i<n; i++){
        if(arr[i] % 3 == 0 || arr[i] % 5 == 0){
            printf("%d ", arr[i]);
        }
    }
    return 0;
}