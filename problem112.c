#include <stdio.h>
#include <stdbool.h>

inline static bool isBouncy(int n) {
    int d;
    int cmp = 0;
    int d_prev = n % 10;
    n /= 10;
    d = n % 10;
    //printf("%d ", d_prev);
    while (d == d_prev && n > 9) {
        d_prev = d;
        n /= 10;
        d = n % 10;
        //printf("%d ", d_prev);
    }
    //printf("%d ", d);
    if (d == d_prev) {
        cmp = 0;
    } else if (d > d_prev) {
        cmp = -1;
    } else if (d < d_prev) {
        cmp = 1;
    }
    //printf(" cmp: %d ", cmp);
    while ( n > 9) {
        d_prev = d;
        n /= 10;
        d = n % 10;
        //printf("%d (n: %d) ", d_prev, n);
        if (d > d_prev && cmp == 1) return true;
        if (d < d_prev && cmp == -1) return true;
    }
    return false;
}


int main() {
    int i = 1;
    int n_bouncy = 0;
    double limit = 0.9;
    //limit = 0.5;
    limit = 0.99;
    while (true) {
    //while (i < 1001) {
        if (isBouncy(i)) {
            n_bouncy++;
            //printf("    bouncy\t");
        } else {
            //printf("not bouncy\t");
        }
        //if (i > 1586980) printf("%d : %.9f\n", i, (double)n_bouncy / i);
        if ((double)n_bouncy / i >= limit) {
            break;
        }
        i++;
    }
    printf("%d\n", i);
    return 0;
}

