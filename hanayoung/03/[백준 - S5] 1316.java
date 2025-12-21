import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            boolean[] alpha = new boolean[26];
            boolean isGroup = true;
            char prev = str.charAt(0);
            for(int j = 1; j < str.length(); j++) {
                if(prev != str.charAt(j)) {
                    if(alpha[prev-'a'] == false) {
                        alpha[prev-'a'] = true;
                    } else {
                        isGroup = false;
                        break;
                    }
                    prev = str.charAt(j);
                }
            }
            if(alpha[prev-'a'] == true) isGroup = false; 
            if(isGroup == true) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
