import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        // String[] guide = new String[N];
        HashMap<String, Integer> guideString = new HashMap<>();
        HashMap<Integer, String> guideInteger = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            guideString.put(name, i+1);
            guideInteger.put(i+1, name);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            Character firstLetter = tmp.charAt(0);
            if(Character.isDigit(firstLetter)) {
                System.out.println(guideInteger.get(Integer.valueOf(tmp)));
            } else {
                System.out.println(guideString.get(tmp));
            }
        }
    }
}
