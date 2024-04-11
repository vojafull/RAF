#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX 255


void puni(int mat[][MAX], int n, int broj) {

    int levo = 0, desno = n - 1, gore = 0, dole = n - 1;

    for (int i = 0; i < n/2; i++) {

        for (int j = desno; j > levo; j--) {
            mat[gore][j] = (broj % 10);

        }
        broj += 2;
        for (int j = gore; j < dole; j++) {
            mat[j][levo] = (broj % 10);

        }
        broj += 2;
        for (int j = levo; j < desno; j++) {
            mat[dole][j] = (broj % 10);
        }
        broj += 2;
        gore++;

        for (int j = dole; j > gore; j--) {
            mat[j][desno] = (broj % 10);
        }
        broj += 2;

        mat[gore][desno] = broj % 10;

        dole--; desno--; levo++;


    }

    broj += 2;

    mat[levo][gore] = broj % 10;


}

void ispisiMat(int mat[][MAX], int n) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%2d", mat[i][j]);

        }
        putchar('\n');
    }

}



int main()
{
    int n, m, mat[MAX][MAX];

    do {
        scanf("%d%d", &n, &m);
    } while (n < 0 || n>9 || m < 1 || m>9);

    puni(mat, m, n);


    putchar('\n');
    ispisiMat(mat, m);

    return 0;
}
