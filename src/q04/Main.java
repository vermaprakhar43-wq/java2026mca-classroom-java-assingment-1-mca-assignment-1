import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        if (!sc.hasNextInt()) return;
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            boolean isP = isPrime(num);
            boolean isF = isPerfect(num);

            if (isP && isF) {
                System.out.println("Both");
            } else if (isP) {
                System.out.println("Prime");
            } else if (isF) {
                System.out.println("Perfect");
            } else {
                System.out.println("Neither");
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean isPerfect(int n) {
        if (n <= 1) return false;
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }
}
