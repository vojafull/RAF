#include <stdio.h>
#include <math.h>

float rek(int n){

    if(n==0) return 0;

    float i=2;
    if(n%2==0) i=1;


    return sqrt(i/n + (rek(n-1)));
}

float ite(int n){

    float sum=sqrt(2);

    for(int j=2; j<=n;j++){

        float i=2;
        if(j%2==0) i=1;
        sum=sqrt(sum+i/j);
    }

    return sum;
}


int main()
{
    int n;
    scanf("%d", &n);

    printf("%f\n", rek(n));
    printf("%f", ite(n));

    return 0;
}
