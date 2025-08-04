import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        People[] people = new People[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i] = new People(height, weight);
        }

        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            int order = 1;
            for (int j = 0; j < N; j++) {
                if (people[i].height < people[j].height && people[i].weight < people[j].weight) {
                    // 큰 덩치
                    order += 1;
                } 
            }
            ranks[i] = order;
        }
        for (int i = 0; i < ranks.length; i++) {
            sb.append(ranks[i]).append(" ");
        }
        System.out.println(sb);
    }

    static class People {
        int height;
        int weight;

        People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
