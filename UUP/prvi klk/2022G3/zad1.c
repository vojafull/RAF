#include <stdio.h>


int prost(int n) {

    if (n % 2 == 0 && n != 2) return 0;
    for (int i = 3; i < n / 2; i += 2) {
        if (n % i == 0) return 0;

    }
    return 1;
}

int pom(int p, int k) {

    int sred = (p + k) / 2;

    int m, v;

    for (int i = sred; i; i++) {
        if (prost(i)) {
            v = i;
            break;
        }
    }
    for (int i = sred; i; i--) {
        if (prost(i)) {
            m = i;
            break;
        }
    }

    if (v - sred < sred - m) return v;
    return m;

}

int main() {

    int a, b;
    int brm = 0, brv = 0;

    scanf("%d %d", &a, &b);

    int s = pom(a, b);

    for (int i = a; i <= b; i++) {
        if (prost(i)) {
            if (i < s) brm++;
            else if (i > s) brv++;
        }

    }

    printf("Manjih %d, Vecih %d", brm, brv);

    return 0;
}
