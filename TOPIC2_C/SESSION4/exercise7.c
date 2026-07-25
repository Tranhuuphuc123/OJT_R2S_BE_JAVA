/*Exercise 07: Find and display all the prime numbers in the array. 
 => hien thi tat cac so nguyen to trong mang 
 => so nguyen to la so lon hon 1 va chi chia het cho 1 va chinh no
  + vd: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
   \...
*/
#include <stdio.h>
int main(){
    int n, i, j, songuyento;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    //nhap vao tung phan tu mang
    for(i = 0; i<n; i++){
        printf("phan tu mang thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //kiem tra va in ra cac so nguyen to trong mang
    printf("cac so nguyen to trong mang la: ");
    for(i = 0; i<n; i++){
        songuyento = 1; //gia su so nguyen to
        if(arr[i] < 2){
            songuyento = 0; //khong phai so nguyen to
        }else{
            for(j = 2; j <= arr[i]/2; j++){
                if(arr[i] % j == 0){
                    songuyento = 0; //khong phai so nguyen to
                    break;
                }
            }
        }
        if(songuyento){
            printf("%d ", arr[i]);
        }
    }
}