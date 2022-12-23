#include <stdio.h>

int main() {
        long n = 0;
        for (int i = 0; i < 10000; i++) {
                if (i % 3 == 0 || i % 5 == 0)
                        n += i;
        }
        printf("%lu\n", n);
}
