#include <iostream>
#include <cmath>

using namespace std;

inline bool prim(int x) {
    if (x < 2) return false;
    int limit = static_cast<int>(sqrt(x) + 1);
    for (int i = 2; i < limit; i++) {
	if (x % i == 0) return false;
    }
    return true;
}

int main() {
    int n = 1;
    int x = 1;
    int p = 0;
    while (n < 10001) {
	if (prim(x)) {
	    p = x;
	    n++;
	}
	x++;
	x++;
    }
    cout << p << endl;
    return 0;
}
