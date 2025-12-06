
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m;

    static class Node {

        int num, cnt, idx;

        Node(int num, int idx, int cnt) {
            this.num = num;
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사진 틀 수
        int m = Integer.parseInt(br.readLine());

        int[] nums = new int[m];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        // 1: 1, 2: 3, 3: 1, 4: 1, 5: 1, 6: 1
        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int candidate = nums[i];

            if (map.containsKey(nums[i])) {
                // 이미 있으면
                map.get(candidate).cnt++; // 추천 수 증가
            } else {
                if (map.size() < n) { // 추천수 여유 있을 때
                    map.put(candidate, new Node(candidate, i, 1));
                } else {
                    // 꽉 찾으면 제거 => cnt가 가장 작고 같으면 idx가 가장 작은 것 제거
                    int removeNum = -1;
                    int minCnt = Integer.MAX_VALUE;
                    int minIdx = Integer.MAX_VALUE;

                    for (Node node : map.values()) {
                        if (node.cnt < minCnt || (node.cnt == minCnt && node.idx < minIdx)) {
                            minCnt = node.cnt;
                            minIdx = node.idx;
                            removeNum = node.num;
                        }
                    }

                    map.remove(removeNum);
                    map.put(candidate, new Node(candidate, i, 1));

                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();

        for (Node node : map.values()) {
            ans.add(node.num);
        }

        Collections.sort(ans);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

}
