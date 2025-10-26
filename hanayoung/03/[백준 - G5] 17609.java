import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            String str = new StringTokenizer(bf.readLine()).nextToken();

            int start = 0, end = str.length() - 1;
            int answer = 0; // 0은 회문, 1은 유사, 2는 아님

            answer = isPalindrome(str, start, end, 0);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int isPalindrome(String str, int start, int end, int answer) {
        if(start >= end) return answer;
        int flag = 0;
        if (str.charAt(start) == str.charAt(end)) {
            flag = isPalindrome(str, start+1, end-1, answer);
        } else {
            int leftMove = 0;
            int rightMove = 0;
            if (answer == 0 && str.charAt(start + 1) == str.charAt(end)) {
                leftMove = isPalindrome(str, start+2, end-1, 1);
            } 
            if (answer == 0 && str.charAt(start) == str.charAt(end - 1)) {
                rightMove = isPalindrome(str, start+1, end-2, 1);
            }
            if(leftMove == 1 || rightMove == 1) flag = 1;
            else flag = 2;
        }
        return flag;
    }
}
