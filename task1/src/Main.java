public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(calculateRoute(n, m));
    }

    private static String calculateRoute(int n, int m) {
        if (n == 0 || m == 0) {
            return String.valueOf(0);
        }
        if (n == 1 || m == 1) {
            return String.valueOf(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        int count = 1;
        while (true) {
            count = count - 1 + m;
            if (count <= n) {
                sb.append(count);
            } else {
                count -= n;
                if (count == 1) {
                    break;
                }
                sb.append(count);
            }
        }
        return sb.toString();
    }
}
