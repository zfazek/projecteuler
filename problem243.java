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
        //int size = primes.size();
        while (n > 1/* && i < size*/) {
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

    static int phiEuler(int x) {
        int n = 1;
        int d = 1;
        for (Integer f : primeFactors(x)) {
            n = n * (f - 1);
            d = d * f;
        }
        return x / d * n;
    }

    public static void bruteForce() {
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
            if (isPrime(i)) {
                primes.add(i);
                primset.add(i);
                //continue;
            }
            phi = phiEuler(i);
            if ((long)phi * (minNumber - 1) < (long)minPhi * (i - 1)) {
                minNumber = i;
                minPhi = phi;
            }
            if (i % 1_000_000 == 0)
                System.out.printf("n:%10d min number: %10d min phi: %10d min value:%12.10f target:%12.10f prime factor: %s\n",
                        i, minNumber, minPhi, (double)minPhi/(minNumber - 1), (double)n/d, new TreeSet<Integer>(primeFactors(minNumber)));
            //System.out.println((double)phi/(i-1));
            //System.out.printf("%d %d\n", phi * d, n * (i - 1));
        } while ((long)phi * d >= (long)n * (i - 1) /*&& i < 20_000_000*/); 
        System.out.println();
        //System.out.printf("%d %d %d\n", phi, phi*d, n*(i-1));
        System.out.printf("n:%10d min number: %10d min phi: %10d min value:%12.10f target:%12.10f prime factor: %s\n",
                i, minNumber, minPhi, ((double)minPhi/(minNumber - 1)), ((double)n/d), new TreeSet<Integer>(primeFactors(minNumber)));
    }

    public static void main(String[] argv) {
        primes = new ArrayList<Integer>();
        primset = new HashSet<Integer>();

        bruteForce();

        /*
        int limit = 100_000;
        int sejtes = 223092870; // sqrt: 14936 phi: 36495360

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
                phiEuler(sejtes),
                (double)(phiEuler(sejtes))/(sejtes-1)); //???
        //System.out.printf("primeFactors(%d) = %s\n", 94745, primeFactors(94745));
        int ss = 1;
        for (int p : primeFactors(sejtes))
            ss *= p;
        //System.out.printf("%d\n", (long)(ss * 23 * 29));
        //System.out.printf("%d phi:%d\n", 94746, phiEuler(94746));
        */

    }
}
