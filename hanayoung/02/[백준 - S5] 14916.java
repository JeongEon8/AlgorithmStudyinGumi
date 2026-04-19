import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        if(n == 1 || n == 3) System.out.println(-1);
        else {
            int answer = n / 5; // 동전 개수
            int rem = n % 5; // 나눠줘야 할 남은 금액

            if(rem % 2 != 0) {
                if((rem + 5) % 2 == 0) {
                    answer -= 1;
                    answer += (rem + 5) / 2;
                } else {
                    answer -= 2;
                    answer += (rem + 10) / 2;
                }
            } else {
                answer += rem / 2;
            }
            System.out.println(answer);
        }
    }
}
