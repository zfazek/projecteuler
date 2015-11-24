#include<iostream>
#include<vector>

using namespace std;

int sum(int x, vector<int> xs) {
    if (x == 0) return 1;
    else if (xs.empty()) return 0;
    else if (x < 0) return 0;
    else {
        int s = 0;
        for (int i = 0; i <= x/xs.back(); ++i) {
            int last = xs.back();
            xs.pop_back();
            s += sum(x - i * last, xs);
            xs.push_back(last);
        }
        return s;
    }
}

int sum1(int x, int xs) {
    if (x == 0) return 1;
    else if (xs == 0) return 0;
    else if (x < 0) return 0;
    else {
        int s = 0;
        for (int i = 0; i <= x/xs; ++i) {
            s += sum1(x - i * xs, xs - 1);
        }
        return s;
    }
}

int main() {
    int ss = 100;
//    vector<int> ls;
//    for (int i = 1; i < ss; ++i)
//        ls.push_back(i);
//    cout << ss << " " << sum(ss, ls) << endl;
    cout << ss << " " << sum1(ss, ss - 1) << endl;
    return 0;
}
