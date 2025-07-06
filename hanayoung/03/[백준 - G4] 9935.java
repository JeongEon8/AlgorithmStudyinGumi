import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();
        st = new StringTokenizer(bf.readLine());

        String bomb = st.nextToken();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if(sb.length() >= bomb.length()) {
                if(sb.substring(sb.length()-bomb.length()).equals(bomb)) sb.delete(sb.length()-bomb.length(), sb.length());
            }
        }

        if(sb.length() == 0) sb.append("FRULA");
        System.out.println(sb);
    }
}
