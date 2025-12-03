package factorization;

import java.util.Arrays;

public class Factorization {
    public static void main(String[] args) {
        basicFactorize(18);
        factorize2(18);
    }
    static void basicFactorize(int N) {
        for(int i = 2; i * i <= N; ++i) {
            while(N % i == 0) {
                System.out.print(i + " ");
                N /= i;
            }
        }
        System.out.println();
    }

    static void factorize2(int N) {
        //소수 구하기
        int n = (int) Math.sqrt(N);
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, 2, n + 1, true);

        for(int i = 2; i <= n; ++i) {
            if(isPrime[i]) {
                for(int j = i * 2; j <= n; j += i) isPrime[j] = false;
            }
        }

        //소인수 분해
        for(int i = 2; i * i <= N; ++i) {
            if(isPrime[i]) {
                while(N % i == 0) {
                    System.out.print(i + " ");
                    N /= i;
                }
            }
        }
//
//        if(N != 1) System.out.println(N);
        System.out.println();
    }
}
