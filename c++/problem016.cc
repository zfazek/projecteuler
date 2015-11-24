#include<iostream>

using namespace std;

int main() {
    long long n = 1;
    for (int i = 0; i < 64; i++)
        n *= 2;
    cout << n << endl;
    return 0;
}
