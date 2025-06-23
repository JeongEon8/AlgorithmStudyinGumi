import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = sc.nextInt();
        }

        // 점수와 인덱스 묶기
        Integer[] order = new Integer[8];
        for (int i = 0; i < 8; i++) {
            order[i] = i;
        }

        // 점수 기준 내림차순 정렬
        Arrays.sort(order, (a, b) -> scores[b] - scores[a]);

        int sum = 0;
        List<Integer> selected = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            sum += scores[order[i]];
            selected.add(order[i] + 1);
        }

        // 인덱스 오름차순 정렬
        Collections.sort(selected);

        System.out.println(sum);
        for (int idx : selected) {
            System.out.print(idx + " ");
        }
    }
}
