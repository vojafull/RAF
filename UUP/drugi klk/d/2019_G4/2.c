#include <stdio.h>
#include <math.h>
#include <string.h>
#define MAX 100


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
            printf("%2d", mat[i][j]);
        }
        putchar('\n');
    }
}

int raz(int mat[][MAX], int r, int c, int n) {

    int max = -999999, min = 99999;

    for (int i = 0; i < n; i++) {
        if (i != r && max < mat[i][c]) max = mat[i][c];

        for (int j = 0; j < n; j++) {

           if (j != c && min > mat[r][j]) min = mat[r][j];

        }
    }

    return abs(min - max);

}

void novaa(int mat[][MAX], int nova[][MAX], int n) {


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            nova[i][j] = raz(mat, i, j, n);
        }
    }
}

int main()
{
    int mat[MAX][MAX], n;
    int nova[MAX][MAX];
    scanf("%d", &n);

    scanMat(mat, n);

    novaa(mat, nova, n);

    putchar('\n');
    ispisiMat(nova, n);

    return 0;
}
