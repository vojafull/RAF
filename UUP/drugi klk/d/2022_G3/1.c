#include <stdio.h>
#include <stdlib.h>
#include <math.h>


float rek(int n, int i, int pol) {

    if (i == pol) return sqrt(1.0 * i / pow(i, 2));

    else {
        if (n > i) {
            return sqrt(1.0 * n / pow(i, 2) + rek(n - 1, i + 1, pol));

        }
        else {

            return sqrt(1.0 * i / pow(i, 2) + rek(i + 1, i + 1, pol));


        }
    }
}

float ite(int n) {

    float sum=0;

    for (int i = n, j = 1; i > 0; i--, j++) {
        int max = i > j ? i : j;
        sum = sqrt(1.0 * max / pow(i, 2) + sum);
    }

    return sum;

}
int main()
{
    int n;
    scanf("%d", &n);

    int pol = n;

    printf("%f\n%f", rek(n, 1, pol), ite(n));


    return 0;
}
