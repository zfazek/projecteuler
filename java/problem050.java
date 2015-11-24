import java.util.ArrayList;

class Tuple {
    int x;
    int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Problem050 {
    static ArrayList<Integer> primes = new ArrayList<Integer>();
    static ArrayList<Tuple> p1 = new ArrayList<Tuple>();

    public static boolean isPrime(int x) {
        int limit = (int)(Math.sqrt(x) + 1);
        if (x < 2) return false;
        for (int i = 2; i < limit; i++)
            if (x % i == 0) return false;
        return true;
    }

    public static int func(int x) {
        int init_i = 0;
        int max = 0;
        while (primes.get(init_i) < x) {
            int n = 0;
            int i = init_i;
            while (n < x) {
                n += primes.get(i);
                i++;
            }
            if (n == x && i - init_i > max)
                max = i - init_i;
            init_i++;
        }
        return max;
    }


    public static void main(String[] args) {
        int limit = 1000000;
        for (int i = 2; i < limit; i++) 
            if (isPrime(i)) primes.add(i);
        for (int i = 0; i < primes.size(); i++) {
            Tuple t = new Tuple(primes.get(i), func(primes.get(i)));
            p1.add(t);
        }
        System.out.println("Number of Primes under " + limit + ": " +
                p1.size());
        int m = -1;
        int mi = -1;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).y > m) {
                m = p1.get(i).y;
                mi = i;
            }
        }
        System.out.println(p1.get(mi).x + ", " +  p1.get(mi).y);
    }

}

