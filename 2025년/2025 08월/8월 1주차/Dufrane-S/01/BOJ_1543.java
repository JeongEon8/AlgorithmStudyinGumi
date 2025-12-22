import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String keyword = br.readLine();
        int answer=0;
        while(s.indexOf(keyword)!=-1){
            s = s.substring(s.indexOf(keyword)+keyword.length());
            answer++;
        }
        System.out.println(answer);
    }
}
