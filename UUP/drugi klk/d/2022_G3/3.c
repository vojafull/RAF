#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void pomeri_nadji(char str[100], int* p, int* k) {

    *p = *k+2;
    int i = *p;

    for (i; i < strlen(str); i++) {
        if (str[i] == ' ') { *k = i - 1; break; }
    }

    if (i >= strlen(str)) *k = strlen(str)-2;

}



int main() {

    char str[100];
    int pocetak = 0, kraj;

    fgets(str, 100, stdin);
    int br = 0;

    for (br; br < strlen(str);br++) {
        if (str[br] == ' ') { kraj = br - 1; break; }
    }
    if (br >= strlen(str)) kraj = strlen(str) - 2;

    int br1 = 0;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == ' ') br1++;
    }
    br1++;


    for (int j = 0; j < br1; j++) {
        for (int i = 0; i <= (kraj-pocetak)/2; i++) {

            int prva = str[i+pocetak] - '0';
            int druga = str[kraj - i] - '0';


            str[i + pocetak] = (prva + i + 1) % 10 +'0';
            str[kraj - i] = (druga + i + 1) % 10 +'0';


        }
        pomeri_nadji(str, &pocetak, &kraj);
    }
    fputs(str, stdout);

    return 0;
}
