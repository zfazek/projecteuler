#include <stdio.h>
#include <time.h>
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <math.h>

using namespace std;

typedef struct triangle {
    int a;
    int b;
    int c;
    bool operator==(const triangle& x) const {
        return x.a == a && x.b == b && x.c == c;
    }
} triangle;

struct Hash {
    size_t operator() (const triangle& x) const {
        return x.a + x.b + x.c;
    }
};

int step = 100;
int old = 1700;
int n = old + step;
int r = 1000000;

unordered_map<int, int> result_map;
int t;
int res;
triangle tri;

int gcd(int a, int b) {
    int temp;
    while (a > 0) {
        temp = a;
        a = b % a;
        b = temp;
    }
    //printf("a: %d, b: %d\n", a, b);
    return b;
}

void printTime(int t) {
    int hour = t / 3600;
    int minute = (t - hour * 3600) / 60;
    int second = t - hour * 3600 - minute * 60;
    printf("\t%7d (%02d hour, %02d minutes, %02d seconds)\n", 
            res, hour, minute, second);
}

int getResult(int limit) {
    int SZORZO = 30;
    vector<triangle> p;
    unordered_set<triangle, Hash> p1;
    unordered_set<triangle, Hash> p2;
    int m = 2;
    int n = 1;
    int a = m * m - (int)pow(n, n);
    int b = 2 * m * n;
    int c = m * m + n * n;
    while (c < SZORZO*limit) {
        n = 1;
        while (n < m) {
            a = m*m-n*n;
            b = 2*m*n;
            c = m*m + n*n;
            if (a<SZORZO*limit && b<SZORZO*limit && c<SZORZO*limit && 
                    a*a + b*b == c*c && gcd(a, b) == 1) {
                tri.a = min(a,b);
                tri.b = max(a,b);
                tri.c = c;
                //printf(" (%d, %d, %d)\n", tri.a, tri.b, tri.c);
                p.push_back(tri);
            }
            ++n;
        }
        ++m;
    }

    //printf("Number of primitive triplets: %d\n", p.size());

    p1.clear();
    for (const auto &i : p) {
        int k = 1;
        while (true) {
            if (i.c * k < SZORZO * limit) {
                tri.a = i.a * k;
                tri.b = i.b * k;
                tri.c = i.c * k;
                p1.insert(tri);
                //printf(" %d, %d, %d\n", tri.a, tri.b, tri.c);
                ++k;
            }
            else
                break;
        }
    }

    p2.clear();
    for (const auto &i : p1) {
        tri.a = i.a * i.a;
        tri.b = i.b * i.b;
        tri.c = i.c * i.c;
        p2.insert(tri);
    }

    //printf("Number of all triplets: %d", p1.size());

    int sum = 0;
    int x, y;
    triangle t1, t2;
    for (int a = 1; a < limit + 1; ++a)
        for (int b = a; b < limit + 1; ++b)
            for (int c = b; c < limit + 1; ++c) {
                x = (a + b) * (a + b);
                y = c * c;
                t1.a = y;
                t1.b = x;
                t1.c = x + y;
                t2.a = x;
                t2.b = y;
                t2.c = x + y;
                if (p2.find(t1) != p2.end() || p2.find(t2) != p2.end()) {
                    //printf("%d, %d, %d\n", a,b,c);
                    ++sum;
                }
            }
return sum;
}

int main() {
    bool increase;
    while (old != n) {
        if (old < n)
            increase = true;
        else
            increase = false;
        printf("%5d", n);
        fflush(stdout);
        int start = (int)time(NULL);
        if (result_map.find(n) != result_map.end()) {
           res = result_map[n];
        }
        else {
            res = getResult(n);
            result_map[n] = res;
        }
        int end = (int)time(NULL);
        t = end - start;
        printTime(t);
        if (res < r) {
            old = n;
            if (increase == false)
                step /= 2;
            n += step;
        }
        else {
            old = n;
            if (increase)
                step /= 2;
            n -= step;
        }
    }
}
