import java.util.*;


public class problem243 {

    static ArrayList<Integer> primes;
    static HashSet primset;

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
	    if (primset.contains(n)) {
		    ret.add(n);
		    return ret;
	    }
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

    static int phiEuler(int x, Set<Integer> factors) {
	int n = 1;
	int d = 1;
	for (Integer f : factors) {
	    n = n * (f - 1);
	    d = d * f;
	}
	return x / d * n;
    }
    
    public static void main(String[] argv) {
	primes = new ArrayList<Integer>();
	primset = new HashSet<Integer>();

	int r = 0;
	float minValue = 1f;
	int minNumber = 0;
	int i = 100_000_000;
	i = 1;
	float lim = 0.4f;
	lim = 15499f / 94744;
	float res = 1f;
	do {
	    ++i;
	    if (isPrime(i)) {
		primes.add(i);
		primset.add(i);
	    }
	    if (primset.contains(i)) continue;
	    r = phiEuler(i, primeFactors(i));
	    res = (float)r / (i - 1);
	    if (res < minValue) {
		minValue = res;
		minNumber = i;
	    }
	    if (i % 1_000_000 == 0)
		System.out.printf("n:%10d min number: %10d min value:%10.6f target:%10.6f\n", i, minNumber, minValue, lim);
	} while (res >= lim);
	System.out.printf("n:%10d min number: %d min value:%10.6f target:%10.6f\n", i, minNumber, minValue, lim);
    }
}
