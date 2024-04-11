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


int nadji(int mat[][MAX], int n, int r, int c) {

    int max = 0;

    if ((mat[r - 1][c]) % 2 == 0 && mat[r - 1][c] > max && r - 1 >= 0) max = mat[r - 1][c];
    if (mat[r + 1][c] % 2 == 0 && mat[r + 1][c] > max && r + 1 <= n - 1) max = mat[r + 1][c];
    if (mat[r][c - 1] % 2 == 0 && mat[r][c - 1] > max && c - 1 >= 0) max = mat[r][c - 1];
    if (mat[r][c + 1] % 2 == 0 && mat[r][c + 1] > max && c + 1 <= n - 1) max = mat[r][c + 1];

    return max;

}


void puni(int mat[][MAX], int nova[][MAX], int n) {

    int spor[MAX], glav[MAX];
    int br = 0;

    for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {

            if (i == j) spor[n - i - 1] = mat[i][j];
            else if (i + j == n - 1) { glav[br] = mat[i][j]; br++; }

        }
    }


    for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {

            if (i == j) nova[i][j] = glav[i];
            else if (i + j == n - 1) nova[i][j] = spor[n - j - 1];
            else nova[i][j] = nadji(mat, n, i, j);
        }
    }
}



int main()
{
    int n, mat[MAX][MAX];
    int nova[MAX][MAX];

    scanf("%d", &n);

    scanMat(mat, n);

    puni(mat, nova, n);
    putchar('\n');
    ispisiMat(nova, n);

    return 0;
}
