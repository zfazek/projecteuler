import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Problem072 {
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static Set<Integer> primeFactors(int p,
                                            int x,
                                            Set<Integer> factors) {
        if (x == 1) return factors;
        else if (x % primes.get(p) == 0) {
            factors.add(primes.get(p));
            primeFactors(p, x / primes.get(p), factors);
        }
        else {
//            int temp = primes.remove(0);
            primeFactors(p + 1, x, factors);
//            primes.add(temp);
        }
        return factors;
    }

    public static Set<Integer> primeFactors(ArrayList<Integer> primes,
                                            int x,
                                            Set<Integer> factors) {
        if (x == 1) return factors;
        else if (x % primes.get(0) == 0) {
            factors.add(primes.get(0));
            primeFactors(0, x / primes.get(0), factors);
        }
        else {
            int temp = primes.remove(0);
            primeFactors(0, x, factors);
            primes.add(temp);
        }
        return factors;
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        else {
            for (int i = 2; i < x; i++)
                if (x % i == 0) return false;
            return true;
        }
    }

    public static Pair iter(ArrayList<Integer> xs, int n, int d) {
//        System.out.println(xs.toString() + ", n: " + n + ", d: " + d);
        if (xs.isEmpty()) return new Pair(n, d);
        else {
            int temp = xs.remove(0);
            return iter(xs, n * (temp - 1), d * temp);
        }
    }

    public static int phiEuler(int x, ArrayList<Integer> xs) {
        Pair p = iter(xs, 1, 1);
//        System.out.println("phiEuler: " + p.x + ", " + p.y);
        return x * p.x / p.y;
    }

    public static void main(String[] args) {
        int limit = 1000001;
        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
//        System.out.println(primes.toString());
        System.out.println(primes.size());
        Set<Integer> empty_set = new HashSet<Integer>();
        int result = 0;
        for (int i = 2; i < limit; i++) {
            Set<Integer> ps = primeFactors(0, i, new HashSet<Integer>());
            ArrayList<Integer> res = new ArrayList<Integer>(ps);
            int phi = phiEuler(i, res);
//            System.out.println(i + ", " + phi);
            result += phi;
        }
        System.out.println(result);
    }

}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

