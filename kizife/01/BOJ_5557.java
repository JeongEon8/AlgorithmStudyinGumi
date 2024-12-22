//1학년


import java.util.Scanner;

public class BOJ_5557 {

    static int[] arr;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //dp[j]란?? 현재 숫자까지 고려했을 때, j값을 만들 수 있는 경우의 수
        dp = new long[21]; //가능범위는 0~20
        dp[arr[0]] = 1;

        calculate(n);
        System.out.println(dp[arr[n-1]]);
    }

    private static void calculate(int n) {
        for (int i = 1; i < n-1; i++) {
            long[] next = new long[21]; //다음상태 저장할 배열

            for (int j = 0; j <=20 ; j++) {

                if (dp[j]>0) { //j를 만들 수 있는 경우가 존재하면
                    int plus = j + arr[i]; //더하기의 결과
                    int minus = j - arr[i]; //빼기의 결과

                    if(plus<=20) { //더해서 20 안 넘으면
                        next[plus] += dp[j]; //경우의 수 추가
                    }
                    if(minus>=0) { //빼서 0 이상이면
                        next[minus] += dp[j]; //경우의 수 추가
                    }
                }
            }

            dp=next; //현재상태를 다음상태로 갱신
        }
    }
}
