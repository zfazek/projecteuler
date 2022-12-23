#include <iostream>

using namespace std;

constexpr int LIMIT = 1000000;
long h[LIMIT];

int iter(long x, int n) {
    if (x < LIMIT && h[x] != 0) return h[x] + n;
    else if (x == 1) return n;
    else if (x % 2 == 0) return iter(x / 2, n + 1);
    else return iter(3 * x + 1, n + 1);
}

int main() {
    int max = 0;
    int m = 0;
    for (int i = 2; i < LIMIT; i++) {
        m = iter(i, 0);
        h[i] = m;
        if (m > max) {
            cout << i << " " << m << endl;
            max = m;
        }
    }
    return 0;
}
