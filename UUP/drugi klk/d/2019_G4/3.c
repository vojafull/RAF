#include <stdio.h>
#include <math.h>
#include <string.h>
#define MAX 255


void nadji(char str[MAX], int* p1, int* k1, int* p2, int* k2, int flag) {

    if (!flag) {
        *p1 = *k1+2;

        for (int i = *p1; i < strlen(str); i++) {
            if (str[i] == '-') { *k1 = i - 1; break; }
        }


        *p2 = *k1 + 2;

        for (int i = *p2; i < strlen(str); i++) {
            if (str[i] == '-') { *k2 = i - 1; break; }
        }


    }
    else {

        *p2 = *k2 + 2;
        int i = *p2;

        for (i; i < strlen(str); i++) {
            if (str[i] == '-') { *k2 = i - 1; break; }
        }

        if (i >= strlen(str)) *k2 = strlen(str) - 2;
    }


}


int main()
{
    char str[MAX];
    int br = 0, zbir = 0, brpon = 0, maxbr = 0, max = 0;
    fgets(str, MAX, stdin);

    int p1 = 0, k1 = -1;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '-') {
            br++;
            if (k1 == -1) k1 = i - 1;
        }

    }

    int p2, k2;

    p2 = k1 + 2;

    for (int i = p2; i < strlen(str); i++) {
        if (str[i] == '-') { k2 = i - 1; break; }
    }

    for (int j = 0; j < br; j++) {
        int flag = 1;
        int i = 0;
        zbir = 0;


        for (int p = k1; p >= p1; p--) {
            zbir += (str[p] - '0');

        }

        while (i < br - j) {

            int zbir1 = 0;


            for (int p = k2; p >= p2; p--) {
                zbir1 += (str[p] - '0');

            }

            if (zbir == zbir1) brpon++;

            nadji(str, &p1, &k1, &p2, &k2, flag);

            i++;
        }

        if (maxbr < brpon) {
            max = zbir;
            maxbr = brpon;
        }

        brpon = 0;
        zbir = 0;
        flag = 0;
        nadji(str, &p1, &k1, &p2, &k2, flag);
    }


    printf("Zbir %d, ", max);


    p2 = 0;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '-') {
            k2 = i - 1;
            break;
        }

    }

        int i = 0;


        while (i <= br) {

            int zbir1 = 0;


            for (int p = k2; p >= p2; p--) {
                zbir1 += (str[p] - '0');

            }

            if (max == zbir1) {
                for (int p = p2; p <= k2; p++) {
                    putchar(str[p]);
                }
                putchar(' ');
            }

            nadji(str, &p1, &k1, &p2, &k2, 1);

            i++;
        }





    return 0;
}
