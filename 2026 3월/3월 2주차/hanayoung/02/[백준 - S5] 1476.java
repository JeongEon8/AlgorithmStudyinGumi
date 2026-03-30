import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
      
        int i = 0;
        boolean isRight = false;
        int e = 0;
        int s = 0;
        int m = 0;
        while(isRight == false) {
            if(e == E && s == S && m == M) break;
            if(e == 15) e = 1;
            else e++;
            if(s == 28) s = 1;
            else s++;
            if(m == 19) m = 1;
            else m++;

            i++;
        }

        System.out.println(i);
    }
}
