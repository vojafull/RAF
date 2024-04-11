#include <stdio.h>
#include <math.h>

double rek(int max, int n, int i) {


    if (n == max) return n;

    if (n % 2 == 0) return n - 1.0 * i / rek(max, n + 1, i - 2);
    else return n + 1.0 * i / rek(max, n + 1, i - 2);

}


double ite(int n) {

    int j = 2 * n + 2;

    int pom = 1;

    while (pom < n) {
        j -= 2;
        pom++;

    }


    double suma;
    if ((n - 1) % 2 == 0) suma = (n - 1) - (1.0 * j / n);
    else suma = (n - 1) + (1.0 * j / n);





    for (int i = n - 1; i > 1; i--) {

        j += 2;

        if ((i-1) % 2 == 0) suma = (i - 1) - (1.0 * j / suma);
        else suma = (i - 1) + (1.0 * j / suma);

    }


    return suma;
}


int main()
{

    int n;
    scanf("%d", &n);

    printf("%f\n", rek(n, 1, 2 * n));
    printf("%f", ite(n));

    return 0;
}
