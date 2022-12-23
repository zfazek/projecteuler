#include <iostream>

using namespace std;

int main() {
    int c = 0;
    for (int a = 0; a < 999; a++)
        for (int b = 0; b < 999; b++) {
            c = 1000 - a - b;
            if (a * a + b * b == c * c)
                cout << a << " " << b << " " << c << endl;
        }
    return 0;
}
