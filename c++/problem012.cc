#include <iostream>

using namespace std;

/*
int iter(long long s, long long n, int d) {
    if (n == 0) return d;
    else if (s % n == 0) return iter(s, n - 1, d + 1);
    else return iter(s, n - 1, d);
}
*/

int iter(long long s) {
    int d = 1;
    for (int i = 1; i < s / 2 + 1; i++) {
        if (s % i == 0) d++;
    }
    return d;
}

int main() {
    long long n = 1;
    long long s = 0;
    int d = 0;
    int max = 0;
    while (d < 501) {
        s += n;
//        d = iter(s, s, 0);
        d = iter(s);
        if (d > max) {
            cout << n << " " << s << " " << d << endl;
            max = d;
        }
        n++;
    }
    cout << n << " " << s << " " << d << endl;
    return 0;
}
