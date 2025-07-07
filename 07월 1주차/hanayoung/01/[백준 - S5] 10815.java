import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        
        boolean[] nums = new boolean[20000001];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken())+10000000;
            nums[tmp] = true;
        }
        
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken())+10000000;
            if(nums[target] == false) sb.append("0 ");
            else sb.append("1 ");
        }

        System.out.println(sb);
    }
}
