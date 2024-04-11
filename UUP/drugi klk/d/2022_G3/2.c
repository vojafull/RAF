#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX 255

void scanMat(int mat[][MAX], int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &mat[i][j]);
        }
    }
}

void printMat(int mat[][MAX], int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", mat[i][j]);
        }
        putchar('\n');
    }
}

int max(int mat[][MAX], int n, int m) {

    int max = mat[0][m];

    for (int i = 1; i < n; i++) {
        if (max < mat[i][m]) max = mat[i][m];
    }
    if (max < mat[n][m]) max = mat[n][m];
    return max;

}

void pomeri(int mat[][MAX], int n, int m) {
    int k = max(mat, n, m);

    for (int j = 0; j < k; j++) {
        int tmp = mat[n][m];
        for (int i = n; i >0; i--) {
            mat[i][m] = mat[i - 1][m];
        }
        mat[0][m] = tmp;
    }


}

void palindrom(int mat[][MAX], int n, int m) {

    for (int j = 0; j < m; j++) {
        for (int i = 0; i < n / 2; i++) {

            if (mat[i][j] != mat[n - i][j]) {
                pomeri(mat, n, j);
                break;
            }

        }
    }


}


int main()
{

    int n, m;
    int mat[MAX][MAX];
    scanf("%d%d", &n, &m);
    scanMat(mat, m, n);
    putchar('\n');

    palindrom(mat, n, m);
    printMat(mat, m, n);
    return 0;
}
