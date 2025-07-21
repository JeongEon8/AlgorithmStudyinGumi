import java.util.Scanner;

public class BOJ_3036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int first = arr[0]; //첫번째 링
        for (int i = 1; i < n; i++) {
            int num = cal(first, arr[i]);
            int up = first/num;
            int down = arr[i]/num;
            System.out.println(up + "/" + down);
        }


    }

    // 유클리드 호제법
    public static int cal(int a, int b) {
        while (b != 0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
