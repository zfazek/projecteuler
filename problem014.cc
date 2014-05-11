#include<iostream>

using namespace std;

const int LIMIT = 1000000;
long long hash[LIMIT];

int iter(long long x, int n) {
    if (x < LIMIT && hash[x] != 0) return hash[x] + n;
    else if (x == 1) return n;
    else if (x % 2 == 0) return iter(x / 2, n + 1);
    else return iter(3 * x + 1, n + 1);
}

int main() {
    for (int i = 0; i < LIMIT; ++i) hash[i] = 0;
    int max = 0;
    int m = 0;
    for (int i = 1; i < LIMIT; i+=2) {
        m = iter(i, 1);
        hash[i] = m;
        if (m > max) {
            cout << i << " " << m << endl;
            max = m;
        }
    }
    return 0;
}
