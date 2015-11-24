import java.util.*;

public class problem243 {

    static ArrayList<Integer> primes;

    static boolean isPrime(int n) {
        for (int i = 2; i < (int)Math.sqrt(n) + 1; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static Set<Integer> primeFactors(int n) {
        Set<Integer> ret = new HashSet<Integer>();
        int i = 0;
        int p = 0;
	int size = primes.size();
        while (n > 1 && i < size) {
            p = primes.get(i);
            if (n % p == 0) {
                n = n / p;
                ret.add(p);
            } else {
                ++i;
            }
        }
        return ret;
    }

    static int phiEuler(int x) {
        int n = 1;
        int d = 1;
        for (Integer f : primeFactors(x)) {
            n = n * (f - 1);
            d = d * f;
        }
        return x / d * n;
    }

    static void printLine(int i, int minNumber, int minPhi, int n, int d) {
                System.out.printf("n:%10d min number: %10d min phi: %10d " +
				  "min value:%12.10f target:%12.10f prime factor: %s\n",
				  i,
				  minNumber,
				  minPhi,
				  (double)minPhi/(minNumber - 1),
				  (double)n/d,
				  new TreeSet<Integer>(primeFactors(minNumber)));
    }

    static void bruteForce() {
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
            if ((long)phi * (minNumber - 1) < (long)minPhi * (i - 1)) {
                minNumber = i;
                minPhi = phi;
            }
            if (i % 1_000_000 == 0)
		printLine(i, minNumber, minPhi, n, d);
        } while ((long)phi * d >= (long)n * (i - 1) /*&& i < 20_000_000*/); 
        System.out.println();
	printLine(i, minNumber, minPhi, n, d);
    }

    static void setPrimes(int limit) {
        for (int i = 2; i < limit; ++i) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] argv) {
        primes = new ArrayList<Integer>();
        int limit = 25;
	setPrimes(limit);
        bruteForce();
    }
}
