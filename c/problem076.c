#include<stdio.h>

const int LIMIT = 9999;
long long a[10000][10000];
//long a[101][101];
long long i,j;

int main(){
    a[1][1]=1;
    a[2][1]=1;a[2][2]=2;
    for(i=3;i<LIMIT + 1;i++){
        a[i][1]=1;
        for(j=2;j<i;j++){
            if(j>i-j) a[i][j]=a[i][j-1]+a[i-j][i-j];
            else a[i][j]=a[i][j-1]+a[i-j][j];
        }
        a[i][i]=1+a[i][i-1];
    }
    int n = 2;
    long long r = 0;
    int target = 100000;
    bool cont = true;
    printf("Start\n");
    while (cont) {
        r = a[n][n];
        if (r % target == 0)
            cont = false;
        n++;
        if (n == LIMIT)
            cont = false;
    }
    if (n < LIMIT)
        printf("%d, %lli\n",n, r);
    else 
        printf("No\n");
return 0;
}
