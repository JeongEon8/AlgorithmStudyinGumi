import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Document {
        int page;
        int priority;

        Document(int page, int priority) {
            this.page = page;
            this.priority = priority;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Queue<Document> queue = new LinkedList<>();

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] priorities = new int[n]; // 중요도 기록

            for (int j = 0; j < n; j++) {
                int priority = sc.nextInt();
                queue.add(new Document(j, priority));
                priorities[j] = priority;
            }

            int count = 0; //출력 순서 카운트

            while (!queue.isEmpty()) {
                Document current = queue.poll();
                // 현재 큐 안에서 가장 높은 중요도를 찾음
                boolean hasHigher = false;
                for (Document doc : queue) {
                    if (doc.priority > current.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 중요도가 더 큰 문서가 있다면 뒤로 보냄
                    queue.add(current);
                } else {
                    // 출력
                    count++;
                    if (current.page == m) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }

    }
}
