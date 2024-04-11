#include <stdio.h>
#define MAX 100


void ispis(int mat[][MAX], int n) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

            printf("%2d", mat[i][j]);
        }
        putchar('\n');
    }


}

void dijagonala(int mat[][MAX], int n, int a) {

    for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {

            if (i + j == n - 1) {

                mat[i][j] = a % 10;
                a /= 10;
            }

        }

    }
}

void dijagonala1(int mat[][MAX], int n, int a) {

    for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {

            if (i + j == n) {

                mat[i][j] = a % 10;
                a /= 10;
            }

        }

    }
}

void sredi(int mat[][MAX], int n) {

    int br = 0;

    for (int i = 0; i < n; i++) {
        int flag = 2;
        int omg = 0;
        for (int j = n - 2 - br; j >= 0; j--) {

            if (flag) {
                mat[i][j] = (10+mat[i][n - 1 - i - omg] - 1) % 10;
                flag--;
            }
            else {
                omg += 2;
                flag = 2;
                mat[i][j] = (10+mat[i][n - 1 - i-omg] - 1) % 10;
            }

        }
        br++;
    }

    br = 0;
    for (int i = n-1; i>1; i--)
    {
        int flag = 2;
        int omg = 0;
        for (int j = 2+br; j <= n - 1; j++) {

            if (flag) {
                mat[i][j] = (10 + mat[i][br + omg] + 1) % 10;
                flag--;
            }
            else {
                omg += 2;
                flag = 2;
                mat[i][j] = (10 + mat[i][br + omg] + 1) % 10;
            }
        }
        br++;
    }

}


int main()
{
    int mat[MAX][MAX], n;
    scanf("%d", &n);



    int pom = n;
    int broj = 0;
    while (pom > 0) {
        broj++;
        pom /= 10;
    }

    pom = n;

    dijagonala(mat, broj, n);
    dijagonala1(mat, broj, n);
    sredi(mat, broj);


    ispis(mat, broj);
    return 0;
}
