import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int wordIdx = 0;
        int wordNextIdx = 0;
        int similar = 0;

        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < N; i++) { // 비교단어 1번
            for (int j = 0; j < N; j++) { // 비교단어 2번
                int tmpCnt = 0;
                if(i != j) {
                for (int m = 0; m < N; m++) { // 단어 자릿수
                    if (arr[i].length() <= m || arr[j].length() <= m) break;
                
                    if (arr[i].charAt(m) == arr[j].charAt(m)) {
                        tmpCnt += 1;
                    } else {
                        break;
                    }
                }
                if (tmpCnt > similar) {
                    similar = tmpCnt;
                    wordIdx = i;
                    wordNextIdx = j;
                }
                }
            }
        }
        System.out.println(arr[wordIdx]);
        System.out.println(arr[wordNextIdx]);

    }
}
