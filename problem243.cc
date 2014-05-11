#include <stdio.h>
#include <math.h>
#include <vector>
#include <string>
#include <set>

using namespace std;
		   
vector<int> primes;

bool isPrime(int n) {
  for (int i = 2; i < (int)sqrt(n) + 1; ++i) {
    if (n % i == 0) return false;
  }
  return true;
}

set<int> primeFactors(int n) {
  set<int> ret;
  int i = 0;
  int p = 0;
  int size = primes.size();
  while (n > 1 && i < size) {
    p = primes[i];
    if (n % p == 0) {
      n = n / p;
      ret.insert(p);
    } else {
      ++i;
    }
  }
  return ret;
}

int phiEuler(int x) {
  int n = 1;
  int d = 1;
  for (int f : primeFactors(x)) {
    n = n * (f - 1);
    d = d * f;
  }
  return x / d * n;
}

string getPrimes(set<int> primes) {
  string ret = "";
  for (const auto &p : primes) {
    ret += to_string(p);
    ret += " ";
  }
  return ret;
}

void printLine(int i, int minNumber, int minPhi, int n, int d) {
  printf("n:%10d min number: %10d min phi: %10d min value:%12.10f target:%12.10f prime factor: %s\n",
	 i,
	 minNumber,
	 minPhi,
	 (double)minPhi/(minNumber - 1),
	 (double)n/d,
	 getPrimes(primeFactors(minNumber)).c_str()
	 );
}

void bruteForce() {
  int phi = 1;
  int minPhi = 1;
  int minNumber = 2;
  int i = 1;
  int n = 4;
  int d = 10;
  n = 15499;
  d = 94744;
  do {
    ++i;
    phi = phiEuler(i);
    if ((long long)phi * (minNumber - 1) < (long long)minPhi * (i - 1)) {
      minNumber = i;
      minPhi = phi;
    }
    if (i % 1000000 == 0)
      printLine(i, minNumber, minPhi, n, d);
  } while ((long long)phi * d >= (long long)n * (i - 1) /*&& i < 20000000*/); 
  printf("\n");
  printLine(i, minNumber, minPhi, n, d);
}

void setPrimes(int limit) {
  for (int i = 2; i < limit; ++i) {
    if (isPrime(i)) {
      primes.push_back(i);
    }
  }
}

int main() {
  vector<int> primes;
  int limit = 25;
  setPrimes(limit);
  bruteForce();
}
