class Problem076 {
    
    public static int sum(int x, int xs) {
        if (x == 0) return 1;
        else if (xs == 0) return 0;
        else if (x < 0) return 0;
        else {
            int s = 0;
            for (int i = 0; i <= x/xs; i++)
                s += sum(x - i * xs, xs - 1);
            return s;
        }
    }

    public static void main(String[] args) {
        int ss = Integer.parseInt(args[0]);
        System.out.println(ss + " " + sum(ss, ss - 1));
    }
}
