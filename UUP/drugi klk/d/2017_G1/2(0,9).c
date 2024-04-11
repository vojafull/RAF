#include <stdio.h>
#define MAX 100
#include <math.h>

void printMat(int mat[][MAX], int br) {

    for (int i = 0; i < br; i++) {
        for (int j = 0; j < br; j++) {
            printf("%2d", mat[i][j]);
        }
        putchar('\n');
    }
}


int main()
{
    int mat[MAX][MAX], n;
    scanf("%d", &n);
    int st = 0;
    int br = 0, a = n;
    while (a > 0) {
        br++;
        a /= 10;
    }

    while (n > 0) {
        mat[0][br - st - 1] = n % 10;
        st++;
        n /= 10;

    }

    for (int i = 1; i < br; i++) {
        for (int j = 0; j < br; j++) {

            if (i % 2 == 0){
                if(abs((mat[i - 1][j] - 2) % 10)<0)
                    mat[i][j]=10-(abs((mat[i - 1][j] - 2) % 10));
                     else mat[i][j] = abs((mat[i - 1][j] - 2) % 10);
            }


            else {
                     if(abs((mat[i - 1][j] - 1) % 10)<0)
                    mat[i][j]=10-(abs((mat[i - 1][j] + 1) % 10));
                     else mat[i][j] = abs((mat[i - 1][j] - 1) % 10);
        }
    }}

    printMat(mat, br);

    return 0;
}
