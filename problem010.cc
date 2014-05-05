#include <iostream>

using namespace std;

inline bool prim(int x) {
    for (int i = 2; i < x; i++) {
        if (x % i == 0) return false;
    }
    return true;
}

int main() {
    int x = 2;
    long long s = 0;
    while (x < 2000000) {
        if (prim(x)) {
            s += x;
            cout << x << " " << s << endl;
        }
        x++;
    }
    return 0;
}
