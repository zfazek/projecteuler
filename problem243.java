import java.util.*;

public class problem243 {

    static ArrayList<Integer> primes;
    static HashSet<Integer> primset;

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
	int limit = 100_000;
	int sejtes = 223092870; // sqrt: 14936 phi: 36495360
	primes = new ArrayList<Integer>();
	primset = new HashSet<Integer>();

	for (int i = 2; i < limit; ++i) {
	    if (isPrime(i)) {
		primes.add(i);
		primset.add(i);
		if (i < 100) System.out.println(i);
	    }
	}
	System.out.printf("Number of primes below %d : %d\n", limit, primes.size());
	System.out.printf("%d %s %d %f\n",
			  sejtes,
			  primeFactors(sejtes),
			  phiEuler(sejtes, primeFactors(sejtes)),
			  (double)(phiEuler(sejtes, primeFactors(sejtes))/(sejtes-1))); //???
	//System.out.printf("primeFactors(%d) = %s\n", 94745, primeFactors(94745));
	int ss = 1;
	for (int p : primeFactors(sejtes))
	    ss *= p;
	//System.out.printf("%d\n", (long)(ss * 23 * 29));
	//System.out.printf("%d phi:%d\n", 94746, phiEuler(94746, primeFactors(94746)));

	/*
	int r = 0;
	float minValue = 1f;
	int minNumber = 0;
	int i = 1;
	i = sejtes - 100;
	float lim = 0.4f;
	lim = 15499f / 94744;
	float res = 1f;
	do {
	    ++i;
	    if (isPrime(i)) {
		primes.add(i);
		primset.add(i);
		continue;
	    }
	    r = phiEuler(i, primeFactors(i));
	    res = (float)r / (i - 1);
	    if (res < minValue) {
		minValue = res;
		minNumber = i;
	    }
	    if (i % 1 == 0)
		System.out.printf("n:%10d min number: %10d phi: %10d min value:%12.10f target:%12.10f\n",
				  i, minNumber, r, minValue, lim);
	} while (res >= lim && i < sejtes);
	System.out.printf("n:%10d min number: %d min value:%12.10f target:%12.10f\n",
			  i, minNumber, minValue, lim);
	*/
    }
}
