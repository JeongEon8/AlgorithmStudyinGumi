import java.util.Scanner;

public class BOJ_16926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        rotate(arr, n, m, r);


    }

    public static void rotate(int[][] arr, int n, int m, int r) {
        int circles = Math.min(n, m)/2; //몇 겹 회전하는지

        for (int i = 0; i < circles; i++) {
            int length = (n+m-2- (4*i)) *2; //현재 circle의 길이
            int rot = r % length; //몇번 회전할 건지

            for (int j = 0; j < rot; j++) {
                int start = arr[i][i]; //각 circle의 시작점

                for (int k = i; k < m-1-i; k++) {
                    arr[i][k] = arr[i][k+1];
                }

                for (int k = i; k < n-1-i; k++) {
                    arr[k][m-1-i] = arr[k+1][m-1-i];
                }

                for (int k = m-1-i; k > i; k--) {
                    arr[n-1-i][k] = arr[n-1-i][k-1];
                }

                for (int k = n-1-i; k >i; k--) {
                    arr[k][i] = arr[k-1][i];
                }

                arr[i+1][i] = start;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
