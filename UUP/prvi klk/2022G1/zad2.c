#include <stdio.h>
#include <math.h>

int main() {

    char c;
    char pret = -1, tren;
    char slovo;
    int broj = 0, novbr = 0;
    int brojac = 0;
    int flag = 0;

    while ((c = getchar()) != '\n') {
        tren = c;

        if (pret != -1 && ((pret >= 'A' && pret <= 'Z') || (pret >= 'a' && pret <= 'z')) && tren >= '0' && tren <= '9') {
            slovo = pret;
            flag = 1;

        }
        if (flag && tren >= '0' && tren <= '9') {
            broj = broj * 10 + c - '0';
            brojac++;
            pret = tren;
            continue;
        }


        if (pret != -1 && ((tren >= 'A' && tren <= 'Z') || (tren >= 'a' && tren <= 'z')) && pret >= '0' && pret <= '9') {
            if (slovo == tren) {
                int st = 1;
                novbr = broj % 10 + brojac == 10 ? 0 : broj % 10 + brojac;;
                broj /= 10;
                int j = 1;
                for (int i = 1; i < brojac; i++) {
                    int pom = broj % 10 + brojac - i >= 10 ? broj % 10 + brojac - i-10 : broj % 10 + brojac - i;
                    novbr = novbr + (pom) * st * 10 ;
                    st *= 10;
                    broj /= 10;
                    j++;
                }
                printf("%d", novbr);

            }
            else {
                printf("%d", broj % (brojac * brojac));

            }

            broj = 0, novbr = 0;
            brojac = 0;
            flag = 0;
            pret = tren;
            putchar(c);
            continue;
        }
        if (!flag && tren < '0' && tren > '9'){}
        else putchar(c);
        pret = tren;
    }


    return 0;
}
