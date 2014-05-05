#include <iostream>

using namespace std;

int main() {
    long long a, b;
    a = 0;
    b = 0;
    for (int i = 1; i < 101; i++) {
        a = a + i * i;
        b = b + i;
    }
    b = b * b;
    cout << b << " - " << a << " = " << b - a << endl;
}
