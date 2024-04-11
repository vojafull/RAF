#include <stdio.h>
#include <math.h>

int main() {

    int tren, pret=0, a = 0, brcf=0, zbir=0;
   int fl = 0;
    char c;

    while ((c = getchar()) != '\n') {

        if (c >= '0' && c <= '9') {
            if (!fl) putchar(c);
            a = a * 10 + c - '0';
            continue;
        }
        else if (c == '(') { putchar(c); fl = 1; continue; }
        else if (c == '[') { putchar(c); fl = 1; continue; }

        if (c == ')') {
            int n = a;

            while (n) {
                brcf++;
                n /= 10;
            }
            n = a;
            if (brcf >= 1) {

                pret = n % 10;
                tren = n / 10 % 10;
                if (tren + pret > 9)
                    zbir += (tren + pret - 10) * pow(10, 1) + pret;
                else zbir += (tren + pret) * pow(10, 1) + pret;

                for (int i = 2; i < brcf; i++) {
                    n /= 10;

                    pret = n % 10;
                    tren = n / 10 % 10;
                    if (tren + pret > 9)
                        zbir += (tren + pret - 10) * pow(10, i);
                    else zbir += (tren + pret) * pow(10, i);


                }
            }
            else zbir += n % 10;
            printf("%d", zbir);
            putchar(c);
            a =brcf=zbir=fl= 0;
            continue;
        }

         if (c == ']') {

            int max = a % 10;
            int kv = a * a;

            while (a) {
                a /= 10;
                if (a % 10 > max) max = a;
            }

            printf("%d", kv % max);
            putchar(c);
            a =brcf=zbir=fl= 0;
            continue;
        }

         else { putchar(c); }


       /* tren = c;
        if (c == '(') { putchar(c); flag_m = 1; }
        if (c == '[') { putchar(c); flag_v = 1; }
        if (c == ')') { putchar(pret + '0'); putchar(c); flag_m = 0; }

        if (c >= '0' && c <= '9') {
            int b = c - '0';
            a = a * 10 + b;

            if (flag_m && onaj >=0 && onaj <=9) {
                if (c < '0' || c > '9') putchar(pret);
                else {

                    if (pret + onaj > 9)
                        putchar((pret + onaj -10) +'0');
                    else putchar((pret + onaj) + '0');
                }
            }
        }

        if (!flag_m && !flag_v) putchar(c);
        onaj = pret;
        pret = tren -'0';*/
    }


    return 0;
}
