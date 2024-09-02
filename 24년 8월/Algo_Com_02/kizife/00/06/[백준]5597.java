import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] submitted = new boolean[31]; //인덱스 0은 사용하지 않음

        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            submitted[n] = true;
        }

        int first = 0, second = 0;
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                if (first == 0) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        System.out.println(first);
        System.out.println(second);

    }
}
