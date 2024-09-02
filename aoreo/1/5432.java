import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
 
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(bf.readLine());
 
        int T = Integer.parseInt(st.nextToken()); // 테케 개수
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            int answer = 0;
            int cnt = 0; // ( 개수
            for (int idx = 0; idx < str.length(); idx++) {
                if(str.charAt(idx) == '(') {
                    cnt += 1;
                }else if(str.charAt(idx) == ')' && str.charAt(idx-1) == '(') {
                    cnt -= 1;
                    answer += cnt;
                }else if(str.charAt(idx) == ')' && str.charAt(idx-1) == ')') {
                    cnt -= 1;
                    answer += 1;
                }
            }
 
 
            System.out.println("#" + test_case+" "+answer);
 
        }
    }
}
