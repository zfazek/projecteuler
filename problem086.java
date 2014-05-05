import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

class Triangle {
    int a;
    int b;
    int c;
 
    @Override
    public boolean equals(Object o) {
	if (o == null) return false;
	if (o == this) return true;
	Triangle t = (Triangle)o;
        return t.a == a && t.b == b && t.c == c;
    }

    @Override
    public int hashCode() {
        return a + b + c;
    }
}

public class problem086 {

    static ArrayList<Triangle> p;
    static HashSet<Triangle> p1;
    static HashSet<Triangle> p2;

    static int gcd(int a, int b) {
	int temp;
	while (a > 0) {
	    temp = a;
	    a = b % a;
	    b = temp;
	}
	//System.out.printf("a: %d, b: %d\n", a, b);
	return b;
    }

    static void printTime(int t, int res) {
	int hour = t / 3600;
	int minute = (t - hour * 3600) / 60;
	int second = t - hour * 3600 - minute * 60;
	System.out.printf("\t%7d (%02d hour, %02d minutes, %02d seconds)\n", 
			  res, hour, minute, second);
    }

    static int init(int limit) {
	p = new ArrayList<Triangle>();
	p1 = new HashSet<Triangle>();
	p2 = new HashSet<Triangle>();
	Triangle tri;
	int SZORZO = 30;
	int m = 2;
	int n = 1;
	int a = m * m - (int)Math.pow(n, n);
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
		    tri = new Triangle();
		    tri.a = Math.min(a,b);
		    tri.b = Math.max(a,b);
		    tri.c = c;
		    //System.out.printf(" (%d, %d, %d)\n", tri.a, tri.b, tri.c);
		    p.add(tri);
		}
		++n;
	    }
	    ++m;
	}

	//System.out.printf("Number of primitive triplets: %d\n", p.size());

	for (Triangle i : p) {
	    int k = 1;
	    while (true) {
		if (i.c * k < SZORZO * limit) {
		    tri = new Triangle();
		    tri.a = i.a * k;
		    tri.b = i.b * k;
		    tri.c = i.c * k;
		    p1.add(tri);
		    //System.out.printf(" %d, %d, %d\n", tri.a, tri.b, tri.c);
		    ++k;
		}
		else
		    break;
	    }
	}

	for (Triangle i : p1) {
	    tri = new Triangle();
	    tri.a = i.a * i.a;
	    tri.b = i.b * i.b;
	    tri.c = i.c * i.c;
	    p2.add(tri);
	}

	//System.out.printf("Number of all triplets: %d", p1.size());
    }

    static int getResult(int limit) {
	int sum = 0;
	int x, y;
	Triangle t1;
	Triangle t2;
	for (a = 1; a < limit + 1; ++a)
	    for (b = a; b < limit + 1; ++b)
		for (c = b; c < limit + 1; ++c) {
		    x = (a + b) * (a + b);
		    y = c * c;
		    t1 = new Triangle();
		    t2 = new Triangle();
		    t1.a = y;
		    t1.b = x;
		    t1.c = x + y;
		    t2.a = x;
		    t2.b = y;
		    t2.c = x + y;
		    if (p2.contains(t1) || p2.contains(t2)) {
			//System.out.printf("%d, %d, %d\n", a,b,c);
			++sum;
		    }
		}
	return sum;
    }

    public static void main(String[] argv) {

	int step = 100;
	int old = 0;
	int n = old + step;
	int r = 1000000;
	
	boolean increase;
	HashMap<Integer, Integer> result_map = new HashMap<Integer, Integer>();
	int res;
	int t;

	init(2000);
	
	while (old != n) {
	    if (old < n)
		increase = true;
	    else
		increase = false;
	    System.out.printf("%5d", n);
	    int start = (int)System.currentTimeMillis()/1000;
	    if (result_map.containsKey(n)) {
		res = result_map.get(n);
	    }
	    else {
		res = getResult(n);
		result_map.put(n, res);
	    }
	    int end = (int)System.currentTimeMillis()/1000;
	    t = end - start;
	    printTime(t, res);
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
}
