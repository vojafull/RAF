#include <stdio.h>

int main()
{

    int n;
    scanf("%d", &n);



    for (int i = 0; i < 2 * n - 1; i++) {
        for (int j = 0; j < 2 * n - 1; j++) {

            if(i==2*n-2 && j==n-1) printf("V");
         else if(i>=n-1 && i<2*n-2 && i+j==2*n-2+(2*n-1)/2) printf("/");
             else if(i>=n-1 && i<2*(n-1) && i==j+(2*n-1)/2) printf("\\");
        else if(i>=n-1 && i<j+(2*n-1)/2 && i+j<2*n-2+(2*n-1)/2) printf("*");
        else if(i==0 && j>=n/2 && j<=2*n-1-n/2-1) printf("-");
        else if(i>0 && i<n-1 && (j==n/2 || j==2*n-1-n/2-1)) printf("|");
        else if(i>0 && i<n-1 && j>n/2 && j<2*n-1-n/2-1) printf("*");
           else printf(".");

        }
        printf("\n");
    }

    return 0;
}
