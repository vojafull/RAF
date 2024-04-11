#include <stdio.h>
#include <math.h>

int main() {


    int zbir = 0, br = 1, a, b = 0;
    int s = 0;
    int flag_m = 0, flag_v = 0, fl = 0;
    int min;
    char c, p;

    while ((c = getchar()) != '\n') {
        p = c;

        if (c >= '0' && c <= '9') {
            a = c - '0';
            a = b * 10 + a;
            b = a;
            continue;
        }

        if (c == '(') {
            br = 1;
            fl = 0;
            flag_m = 1;
            continue;
        }

        if (c == '[') {
            br = 1;
            fl = 0;
            flag_v = 1;
            continue;
        }

        if (c == ' ') br++;

        if (c == ' ' || c == ')' || c == ']') {



            if (!fl) min = a;


            if (flag_m) {
                fl = 1;
                if (a < min) min = a;
            }
            else if (flag_v) {
                fl = 1;
                s += a;
            }
            else if (!flag_m && !flag_v) {
                fl = 0;
                zbir += a;
            }
            a = b = 0;
        }

        if (c == ')') {
            zbir += pow(min, br);
            br = 1;
            flag_m = 0;
            fl = 0;
            a = b = 0;
        }

        if (c == ']') {
            if (s % br != 0) zbir++;
            zbir += s / br;
            br = 1;
            flag_v = 0;
            fl = 0;
            a = b = 0;
        }


    }


    if (p != ')' && p != ']') zbir += a;


    printf("%d", zbir);

    return 0;
}
