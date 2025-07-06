import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> hashMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            hashMap.put(st.nextToken(), true);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String target = st.nextToken();

            if(hashMap.containsKey(target)) answer += 1;
        }

        System.out.println(answer);

    }
}
