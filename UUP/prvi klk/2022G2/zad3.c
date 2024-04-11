#include <stdio.h>
#include <math.h>

int main() {

    int n;
    scanf("%d", &n);

    for (int i = 0; i < 2 * n; i++) {
        for (int j = 0; j < 2 * n; j++) {

            if ((i + j == 0) || (i == 0 && j == n) || (j == 0 && i == 2 * n - 1) || (i == 2 * n - 1 && j == 2 * n - 1) || (i == n-1 && j == 2 * n - 1)) printf("+");
            else if(i==j) printf("\\");
            else if(i+j==2*n-1 && i>j-n) printf("/");
             else if(i==j-n) printf("\\");
            else if ((j == 0 || j == 2 * n - 1) && i>j-n) printf("|");
            else if ((i == 0 || i == 2 * n - 1)&& i>j-n) printf("-");
            else if(i<j-n) printf(" ");



            else printf(".");
        }
        printf("\n");
    }


    return 0;
}
