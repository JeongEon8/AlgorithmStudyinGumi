import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

class Solution {

public static void main(String args[]) throws Exception {

    System.setIn(new FileInputStream("input_3752.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken()); // 테케 개수

    for (int test_case = 1; test_case <= T; test_case++) {
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 문제 개수

        int[] tests = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) { // 각 문제 배점
            tests[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < N; i++) {
            HashSet<Integer> copy = (HashSet<Integer>) set.clone(); // set은 clone이 없네
            Iterator<Integer> it = copy.iterator();
            while(it.hasNext()) {
              set.add(it.next() + tests[i]);
            }
        }

        System.out.println("#"+test_case+" "+set.size());
    }
}
}
