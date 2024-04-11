#include <stdio.h>


int uzmibr(int n, int n1) {

    return n * 10 + n1;

}

int main() {

    int a, b = 0;

    int zbir = 0, min, max = 0;

    int flag_m = 0, flag_v = 0, fl=0;

    char c, p;

    while ((c = getchar()) != '\n') {
        p = c;

        if (c >= '0' && c <= '9') {
            a = c - '0';
            a = uzmibr(b, a);
            b = a;
            //if(flag_m==0 && flag_v==0)
            continue;
        }

        if (c == '(') {
            fl = 0;
            flag_m = 1;
            continue;
        }




        if (c == '{') {
            fl = 0;
            flag_v = 1;
            continue;
        }




        if (c == ' ' || c == ')' || c == '}') {

           if (fl == 0 && !flag_m) min = a;

            if (flag_m && a % 2 == 0) {
                if (fl == 0) {
                    fl = 1; min = a;
                }
                else if (a < min) min = a;
            }

            else if (flag_v) {
                fl = 1;
                if (a > max) max = a;
                if (a < min) min = a;
            }

            else if(!flag_m && !flag_v){
                fl == 0;
                zbir += a;
            }

            a = b = 0;

        }

        if (c == ')') {
            zbir += min;
            a = b = 0;
            flag_m = max = 0;
            fl = 0;

        }

        if (c == '}') {
            zbir += max - min;
            a = b = 0;
            flag_v = max = 0;
            fl = 0;

        }
    }

    if (p == ')') zbir += min;
    else if (p == ')') zbir += max - min;
    else zbir += a;

    printf("%d\n", zbir);

    return 0;
}
