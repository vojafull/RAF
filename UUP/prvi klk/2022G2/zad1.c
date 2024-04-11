#include <stdio.h>
#include <math.h>

int pom(int arg) {

    int zbir = 0, br = 0, j=0;
    int n = arg;

    while (arg) {
        br++;
        arg /= 10;
    }
    int st = br - 1;
    for (int i = 1; i <= br; i++) {

        if (i % 2 != 0)
        zbir += n / pow(10, st);

        n%=(int)pow(10, st);
        st--;
    }

    return pow(zbir, br);

}

int main()
{
    int n;

    scanf("%d", &n);
    while (n != 0) {


        int a = 0;
        int cf, ncf, br = 0;
        int flag = 0;
        int broj = pom(n);
        int x = n, y = broj;
        int bb = 0, nn = 0;

        while (y) {
            bb++;
            y /= 10;
        }
        while (x) {
            nn++;
            x /= 10;
        }

        for (int i = nn; i > 0; i--) {
            int x = broj;
            ncf = n % 10;
            while (x) {
                cf = x % 10;
                if (ncf == cf) {
                    flag = 1;
                    break;
                }
                x /= 10;
            }
            if (flag == 0) {
                a += ncf * pow(10, br);
                br++;
            }
            n /= 10;
            flag = 0;
        }

        /*while (n) {
            int x = broj;
            ncf = n % 10;
            while (x) {
                cf = x % 10;
                if (ncf == cf) {
                    flag = 1;
                }
                x /= 10;
            }
            if (flag == 0) {
                a = a * pow(10, br) + ncf;
                br++;
            }
            n /= 10;
            flag = 0;
           }*/


        printf("%d\n", a);
        scanf("%d", &n);
    }

    return 0;
}
