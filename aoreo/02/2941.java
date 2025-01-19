import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String word = st.nextToken();

        int answer = 0;
        int idx = 0;
        int originLen = word.length();
        String originWord = new String(word);
        while(idx < originLen) {
            String check1 = originWord.substring(idx);
            if(originWord.length() >= idx + 2) check1 = originWord.substring(idx, idx+2);
            
            String check2 = originWord.substring(idx);
            if(originWord.length() >= idx + 3) check2 = originWord.substring(idx, idx+3);
   
            if(check1.equals("c=") || check1.equals("c-") || check1.equals("d-") || check1.equals("lj") || check1.equals("nj") || check1.equals("s=") || check1.equals("z=")){
                word = word.replaceFirst(check1, "");
                idx += 2;
                answer += 1;
            }else if(check2.equals("dz=")){
                word = word.replaceFirst(check2, "");
                idx += 3;
                answer += 1;
            }else{
                idx += 1;
            }
        }

        answer += word.length();

        System.out.println(answer);
    }
}
