import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.nextLine();
        StringBuilder result = new StringBuilder();

        int count = 0; // 연속된 X 개수
        for (int i = 0; i < board.length(); i++) {
            char ch = board.charAt(i);

            if (ch == 'X') {
                count++;
            } else {
                // 연속된 X 개수가 홀수면 불가능
                if (count % 2 != 0) {
                    System.out.println("-1");
                    return;
                }
                // AAAA로 먼저 덮기
                while (count >= 4) {
                    result.append("AAAA");
                    count -= 4;
                }
                // 남은 건 BB로...
                while (count >= 2) {
                    result.append("BB");
                    count -= 2;
                }
                result.append('.'); 
            }
        }

        // 마지막이 X로 끝난 경우 처리
        if (count % 2 != 0) {
            System.out.println("-1");
            return;
        }
        while (count >= 4) {
            result.append("AAAA");
            count -= 4;
        }
        while (count >= 2) {
            result.append("BB");
            count -= 2;
        }

        System.out.println(result);
    }
}
