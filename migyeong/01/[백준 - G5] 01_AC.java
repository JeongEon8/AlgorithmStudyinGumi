import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < Test_case; t++) {
            String[] p = br.readLine().split(""); // RDD
            int num = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new LinkedList<>();
            boolean isReversed = false;
            boolean isError = false;

            String line = br.readLine();

            if (num != 0) {
                String temp = line.substring(1, line.length() - 1); // 대괄호 제거
                String[] s = temp.split(",");

                for (int j = 0; j < num; j++) {
                    deque.add(Integer.parseInt(s[j]));
                }
            } else {
                // 빈 배열 입력 확인
                if (line.equals("[]") == false) {
                    System.out.println("error");
                    continue;
                }
            }

            for (String cmd : p) {
                if (cmd.equals("R")) {
                    isReversed = !isReversed;
                } else if (cmd.equals("D")) {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
