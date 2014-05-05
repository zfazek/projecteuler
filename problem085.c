#include <stdio.h>

int getNumRect(int x, int y) {
    int i, j, ret;
    ret = 0;
    for (i = 1; i <= x; ++i)
        for (j = 1; j <= y; ++j) {
            ret += (x - i + 1) * (y - j + 1);
            //printf("%d x %d : %d\n", i, j, ret);
        }
    return ret;
}

int main() {
    int x, y, r;
    int bx, by, br;
    br = 0;
    for (x = 1; x < 300; ++x) {
        for (y = 1; y < 300; ++y) {
            r = getNumRect(x, y);
            if (abs(r-2000000) < abs(br-2000000)) {
                bx = x;
                by = y;
                br = r;
            }
        }
    }
    printf("%d x %d = %d : %d\n", bx, by, bx * by, br);


    /*
    printf("%d x %d : %d\n", 1, 1, getNumRect(1, 1));
    printf("%d x %d : %d\n", 2, 2, getNumRect(2, 2));
    printf("%d x %d : %d\n", 3, 2, getNumRect(3, 2));
    printf("%d x %d : %d\n", 300, 200, getNumRect(300, 200));
    */
}
