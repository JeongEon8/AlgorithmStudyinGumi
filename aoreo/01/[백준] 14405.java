import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken(); 
        int originLen = str.length();

        int replaceLen = (originLen - str.replace("pi", "").length()) + (originLen - str.replace("ka", "").length()) + (originLen - str.replace("chu", "").length());

        if(originLen == replaceLen) System.out.println("YES");
        else System.out.println("NO");
    }
}
