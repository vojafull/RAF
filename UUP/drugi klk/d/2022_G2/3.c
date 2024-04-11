#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void nadji(char str[100], int* p1, int* k1, int* p2, int* k2, int flag) {

    if (!flag) {
        for (int i = *p1; i < strlen(str); i++) {
            if (str[i] == ' ') { *k1 = i - 1; break; }
        }

        *p2 = *k1 + 2;

        for (int i = *p2; i < strlen(str); i++) {
            if (str[i] == ' ') { *k2 = i - 1; break; }
        }
    }

    else {
        *p2 = *k2 + 2;
        int i = *p2;
        for (i; i < strlen(str); i++) {
            if (str[i] == ' ') { *k2 = i - 1; break; }
        }
        if (i >= strlen(str)) *k2 = strlen(str)-2;
    }
}



int main()
{
    char str[100];
    char novi[100];
    int p1 = 0, k1, p2, k2;
    int nbr = 0;

    int brreci = 0;


    fgets(str, 100, stdin);

    for (int i = 0; i < strlen(str); i++) {

        if (str[i] == ' ') brreci++;
    }


    for (int j = 0; j < brreci; j++) {
        int flag = 0;
        nadji(str, &p1, &k1, &p2, &k2, flag);
        flag = 1;
        int i = p2;
        for (i; i < strlen(str); i++) {

            if (str[i] != str[k1]) i += k2 - p2;
            else {

                int prvi = k1;
                int drugi = p2;
                while (str[prvi] == str[drugi]) {
                    prvi--;
                    drugi++;
                }

                if (prvi+1 == p1 && drugi-1 == k2) {

                    for (int a = p1; a <= k1; a++) {
                        novi[nbr] = str[a];
                        nbr++;
                    }
                    novi[nbr] = ' ';
                    nbr++;
                    for (int a = p2; a <= k2; a++) {
                        novi[nbr] = str[a];
                        nbr++;
                    }
                    novi[nbr] = ' ';
                    nbr++;

                    for (int a = p2; a < strlen(str) - k2+p2; a++) {
                        str[a] = str[a + k2-p2+2];
                    }

                    for (int a = 0; a < strlen(str) - k1; a++) {
                        str[a] = str[a + k1+2];
                    }

                }

            }

            nadji(str, &p1, &k1, &p2, &k2, flag);
            if (k2 - p2 < 0) break;
            i = p2-1;
        }
        int b = 0;
        for (int a = 0; a < strlen(str); a++) {
            if (str[a] == ' ')b++;
        }
        if (b == 0) break;
        else if (b > 1) {
            for (int a = 0; a < strlen(str) - k1; a++) {
                str[a] = str[a + k1 + 2];
            }
        }
    }

    novi[nbr] = '\0';
    fputs(novi, stdout);


    return 0;
}
