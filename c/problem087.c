#include <stdio.h>

const int SIZE = 50;

int main() {
    int x1, x2, y1, y2;
    int sum = 0;
    int a, b, c;
    for (x1 = 0; x1 <= SIZE; ++x1)
        for (x2 = 0; x2 <= SIZE; ++x2)
            for (y1 = 0; y1 <= SIZE; ++y1)
                for (y2 = 0; y2 <= SIZE; ++y2)
                    if (!(x1==0&&x2==0)&&!(y1==0&&y2==0)&&!(x1==y1&&x2==y2)) {
                        a = x1 * x1 + x2 * x2;
                        b = y1 * y1 + y2 * y2;
                        c = (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
                        if (a + b == c || a + c == b || b + c == a) {
                            //printf("(%d,%d) (%d,%d)\n", x1, x2, y1, y2);
                            sum++;
                        }
                    }
    printf("%d\n", sum/2);

}
