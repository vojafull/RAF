#include <stdio.h>
#include <stdlib.h>
#include <math.h>


float rek(float n, float a) {

    if (n == a) {
        if ((int)n % 2 == 0) return n * sqrt(n / (pow(n + 1, 2)));
        else return sqrt(n / (n + 1));
    }
    else {
        if ((int)n % 2 == 0) return n * sqrt(n / ((n + 1) * (n + 1)) + rek(n + 1, a));

        else return sqrt(n / (n + 1) + rek(n + 1, a));
    }

}

float ite(int n) {

    float sum = 0;

    while (n > 0) {

        if (n % 2 == 0) {
            sum = n * sqrt(1.0*n / pow(n + 1, 2) + sum);
        }
        else {
            sum = sqrt(1.0*n / (n + 1) + sum);
        }

        n--;
    }


    return sum;

}


int main()
{

    float n;
    scanf("%f", &n);


    printf("%f\n%f", rek(1, n), ite(n));

    return 0;
}
