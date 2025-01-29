import java.util.Scanner;

public class BOJ_17352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] parent = new int[n + 1];

        //부모가 자기 자신 (즉 아직 연결ㄴㄴ)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(parent, a, b);
        }

        //떨어진 섬 찾기
        int root1 = 0;
        int root2 = 0;
        for (int i = 1; i <= n; i++) {
            int root = find(parent, i);
            if (root1 == 0) {
                root1 = root;
            } else if (root1 != root) {
                root2 = root;
                break;
            }
        }

        System.out.println(root1 + " " + root2);
    }

    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootY] = rootX; //그룹 ㅎ바치기
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            //계속 상위 부모 찾기
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
