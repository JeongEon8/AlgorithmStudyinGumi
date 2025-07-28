import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        char type = (st.nextToken()).charAt(0);

        int playerNum = (type == 'Y') ? 2 : (type == 'F') ? 3 : 4;

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            hashSet.add(st.nextToken());
        }

        int answer = hashSet.size()/(playerNum-1);

        System.out.println(answer);
    }
}
