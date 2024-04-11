#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX 255



void scanMat(int mat[][MAX], int n) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &mat[i][j]);

        }

    }
}

void ispisiMat(int mat[][MAX], int n) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", mat[i][j]);

        }
        putchar('\n');
    }

}

void elSort(int mat[][MAX], int c, int n) {

    int i, j;

    for (i = 0; i < n - 1; i++) {

        for (j = 0; j < n - i - 1; j++) {
            if (mat[j][c] > mat[j + 1][c]) {

                int tmp = mat[j][c];
                mat[j][c] = mat[j + 1][c];
                mat[j + 1][c] = tmp;

            }
        }

    }

}

void colSwap(int mat[][MAX], int c1, int c2, int n){

    for(int i=0;i<n;i++){
        int tmp=mat[i][c1];
        mat[i][c1]=mat[i][c2];
        mat[i][c2]=tmp;
    }


}

void colSort(int mat[][MAX],int n){

    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(mat[n-1][j]<mat[n-1][j+1]){
                colSwap(mat,j,j+1,n);
            }
        }
    }

}


int main()
{
    int n, mat[MAX][MAX];

    scanf("%d", &n);

    scanMat(mat, n);

    for (int i = 0; i < n; i++) {
        elSort(mat, i,n);
    }
    for (int i = 0; i < n; i++) {
        colSort(mat,n);
    }

    putchar('\n');
    ispisiMat(mat, n);

    return 0;
}
