import java.util.*;

public class BOJ_2212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        if (k >= n) { //기지국의 개수>=센서의 개수...이면 전송 거리 합=0
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list); //오름차순 정렬

        ArrayList<Integer> dis = new ArrayList<>(); //각 센서간 거리계산
        for (int i = 1; i < n; i++) {
            dis.add(list.get(i) - list.get(i-1));
        }

        Collections.sort(dis, Collections.reverseOrder()); //거리 내림차순 정렬

        int answer = 0;
        for (int i = k-1; i < dis.size(); i++) {
            answer += dis.get(i);
        }

        System.out.println(answer);

    }
}
