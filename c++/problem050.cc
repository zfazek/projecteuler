#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

inline bool prim(int x) {
    int limit = static_cast<int>(sqrt(x) + 1);
    if (x < 2) return false;
    for (int i = 2; i < limit; i++) {
        if (x % i == 0) return false;
    }
    return true;
}

int main() {
  int limit = 1000000;
  vector<int> primes;
  for (int i = 2; i < limit; i++) 
    if (prim(i)) primes.push_back(i);
  cout << "Number of primes under " << limit << ": " 
       << primes.size() << endl;
  return 0;
}
