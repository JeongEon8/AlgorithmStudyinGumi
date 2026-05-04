import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        Collections.sort(list);
        
        int left = 0;
        int right = N-1;

        while(left < right) {
            int sum = list.get(left)+list.get(right);

            if(sum < M) left++;
            else if(sum > M) right--;
            else {
                answer++;
                left++;
                right--;
            }

        }
        System.out.println(answer);
    }
}
