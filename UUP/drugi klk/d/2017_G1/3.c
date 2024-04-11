#include <stdio.h>
#define MAX 100
#include <string.h>


void nadji(char* str, int* p, int* k, int flag) {
    int i = *p;
    if (flag) {


        for (i; i < strlen(str); i++) {

            if (str[i] == ' ') { *k = i - 1; break; }

        }

    }

    else {
        *p = *k + 2;

        i = *p;
        for (i; i < strlen(str); i++) {

            if (str[i] == ' ') { *k = i - 1; break; }

        }

    }

    if (i >= strlen(str)) *k = strlen(str) - 1;
}


void izbrisi(char* str, int p, int k) {
    int a = strlen(str);
    for (int i = p; i < a - k + p; i++) {
        str[i] = str[i + k - p + 2];
    }

}


int main()
{

    char str[MAX];
    int p = 0, k = -1;

    fgets(str, MAX, stdin);

    int brs = 0;


    for (int i = 0; i < strlen(str); i++) {

        if (str[i] == ' ') {
            brs++;
            if (k < 0) k = i - 1;
        }
    }

    for (int j = 0; j <= brs; j++) {

        if (str[p] >= 'a' && str[p] <= 'z' && str[k] >= 'a' && str[k] <= 'z') {

            int a = strlen(str);
            izbrisi(str, p, k);
            nadji(str, &p, &k, 1);



        }

        else nadji(str, &p, &k, 0);
    }
    for (int i = 0; i < strlen(str); i++) {

        if (str[i] == ' ') {
            p = i+1;
        }
    }

    if (str[p] >= 'a' && str[p] <= 'z' && str[strlen(str) - 2] >= 'a' && str[strlen(str) - 2] <= 'z') {


        int a = strlen(str);
        for (int i = p; i < a - k + p; i++) {
            str[i] = str[i + k - p + 1];
        }

    }



    fputs(str, stdout);

    return 0;
}
