#include <iostream>

using namespace std;

int main() {

//    long n = 13195;
    long long n = 600851475143;

    long i = 3;
    while (i <= n) {
        if (n % i == 0) {
            cout << i << endl;
            n /= i;
        }
        i += 1;
    }

    return 0;
}
