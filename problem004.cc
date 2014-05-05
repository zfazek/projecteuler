#include <iostream>
#include <sstream>

using namespace std;

inline bool p(long long x) {
    stringstream ss;
    ss << x;
    string s = ss.str();
    int l = s.size();
    for (int k = 0; k < l; k++) 
        if (s[k] != s[l - k - 1]) return false;
    return true;
}

int main() {
    long long max = 0;
    long long m = 0;
    for (int i = 100; i < 1000; i++) {
        for (int j = 100; j < 1000; j++) {
            m = i * j;
            if (p(m) && m > max) {
                max = m;
                cout << max << endl;
            }
        }
    }
//    cout << max << endl;
    return 0;
}
