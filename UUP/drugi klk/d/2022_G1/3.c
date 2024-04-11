#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void nadji(char str[100], int* p1, int* k1, int* p2, int* k2, int flag) {

    if (!flag) {
        for (int i = *p1; i < strlen(str); i++) {
            if (str[i] == ' ') { *k1 = i; break; }
        }

        *p2 = *k1 + 1;

        for (int i = *p2; i < strlen(str); i++) {
            if (str[i] == ' ') { *k2 = i; break; }
        }
    }

    else {
        int i;
        *p2 = *k2 + 1;
        for (i = *p2; i < strlen(str); i++) {
            if (str[i] == ' ') { *k2 = i; break; }
        }
        if (i >= strlen(str)) *k2 = strlen(str);
    }


}

void ispisi(char str[100], int p1, int k1, int p2, int k2) {


    for (int i = p1; i < k1; i++) {
        putchar(str[i]);
    }
    printf(" ");

    for (int i = p2; i < k2; i++) {
        putchar(str[i]);
    }
    printf("\n");
}


int main() {

    char str[100];
    int pocetak1 = 0, kraj1, pocetak2, kraj2;

    fgets(str, 100, stdin);

    int brreci = 0, poslednji = -1;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == ' ') { brreci++; poslednji = i + 1; }

    }
    brreci++;



    for (int i = 0; i < brreci; i++) {
        int flag = 0, df = 0;

        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == ' ') { poslednji = i + 1; }

        }
        nadji(str, &pocetak1, &kraj1, &pocetak2, &kraj2, flag);

        flag = 1;

        int j = pocetak2;
        while (j <= poslednji) {
            int prvi = pocetak1, drugi = pocetak2;

            for (prvi = pocetak1; prvi < kraj1 - 1; prvi++) {
                for (drugi = pocetak2; drugi < kraj2 - 1; drugi++) {

                    if (str[prvi] == str[drugi] && str[prvi + 1] == str[drugi + 1]) {
                        ispisi(str, pocetak1, kraj1, pocetak2, kraj2);
                        df = 1;
                        break;
                    }
                    if (df) break;
                }


            }
            nadji(str, &pocetak1, &kraj1, &pocetak2, &kraj2, flag);
            j = pocetak2;
        }

        int aaa = strlen(str);

        for (int j = 0; j < aaa-kraj1; j++)
        {
            str[j] = str[j + kraj1+1];

        }

    }


    return 0;
}
