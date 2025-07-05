import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bombStr = br.readLine();
        int bombLen = bombStr.length();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            if (sb.length() >= bombLen && c == bombStr.charAt(bombLen - 1)) {
                boolean isBomb = true;
                // 뒤에서부터 폭탄 문자열이 포함되어있는지 확인
                for (int i = 1; i <= bombLen; i++) {
                    if (bombStr.charAt(bombLen - i) != sb.charAt(sb.length() - i)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) sb.delete(sb.length() - bombLen, sb.length());
            }
        }
        System.out.println(sb.toString().isEmpty() ? "FRULA" : sb);
    }
}
