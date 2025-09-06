// import java.util.Scanner;

// public class BOJ_1057 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int jm = sc.nextInt();
//         int hs = sc.nextInt();

//         int answer = tournament(jm, hs, 1);

//         System.out.println(answer);
//     }

//     static int tournament(int jm, int hs, int count) {
//         if (Math.abs(jm-hs) == 1 && Math.min(jm, hs) %2 ==1) {
//             // 둘이 맞닿는 지점이므로
//             return count;
//         }

//         if (jm % 2 == 0 && hs % 2 == 0) {
//             return tournament(jm / 2, hs / 2, count + 1);
//         } else if (jm % 2 == 1 && hs % 2 == 0) {
//             return tournament(jm / 2 + 1, hs / 2, count + 1);
//         } else if (jm % 2 == 1 && hs % 2 == 1) {
//             return tournament(jm / 2 + 1, hs / 2 + 1, count + 1);
//         } else { // (jm % 2 == 0 && hs % 2 == 1)
//             return tournament(jm / 2, hs / 2 + 1, count + 1);
//         }
//     }
// }


// 위와 같은 노가다를 했는데 걍 while로 퉁치면 되는 거..쩝
import java.util.Scanner;

public class BOJ_1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사실상 안 쓰임
        int jm = sc.nextInt();
        int hs = sc.nextInt();

        int count = 0;

        while (jm != hs) {
            jm = (jm + 1) / 2;
            hs = (hs + 1) / 2;
            count++;
        }

        System.out.println(count);
    }
}
