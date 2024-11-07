import java.util.Scanner;

public class Main {
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        calculate(n, 0);
        System.out.println(min + " " + max);
    }

    private static void calculate(int n, int currentCount) {
    	//'새로운 수' 나올 때마다 홀수 수 세어주기 
        int newCount = currentCount + count(n); //현재 홀수개수 + 새로 센 홀수개수 

        // 한자리수일 경우
        if (n < 10) {
            max = Math.max(max, newCount);
            min = Math.min(min, newCount);
            return;
        }

        // 두자리수일 경우
        if (n < 100) {
            int sum = plus(n); //각 자리 수 합하기 
            calculate(sum, newCount); //다시 호출 
            return;
        }

        // 세자리 이상
        String numStr = Integer.toString(n);
        int length = numStr.length();

        //3덩어리로 나누기 
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String part1 = numStr.substring(0, i);
                String part2 = numStr.substring(i, j);
                String part3 = numStr.substring(j);

                int num1 = Integer.parseInt(part1);
                int num2 = Integer.parseInt(part2);
                int num3 = Integer.parseInt(part3);

                //3덩어리 합 
                int sum = num1 + num2 + num3;

                //다시 호출
                calculate(sum, newCount);
            }
        }
    }

    private static int plus(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n % 10) % 2 != 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
