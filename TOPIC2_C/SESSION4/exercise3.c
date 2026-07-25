/*Exercise 03: Indicates how many times element x appears in the array, with 
x entered by the user 
 => nhap mang cho biet so x nhap vao can tim xuat hien bao lan trong mang do*/
 #include <stdio.h>
 int main(){
    int n, i, x, count = 0;

    printf("nhap vao n phan tu mang: ");
    scanf("%d", &n);

    int arr[n];
    //nhap tung phan tu vao mang
    for(i =0; i<n; i++){
        printf("phan tu mang thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    //nhap vao so x can tim
    printf("nhap vao gia tri x can tim: ");
    scanf("%d", &x);

    //dem so lan xuat hien cua x trong mang 
    for(i =0; i<n; i++){
        if(arr[i] == x )
        count++;
    }
    printf("so lan xuat hien cua %d trong mang la: %d", x, count);
}
