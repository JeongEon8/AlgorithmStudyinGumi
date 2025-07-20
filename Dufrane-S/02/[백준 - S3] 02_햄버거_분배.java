import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        boolean[] done = new boolean[length];
        String s = br.readLine();
        for (int i = 0; i < length; i++) {
            arr[i] = s.charAt(i);
            if (arr[i] == 'P') {
                done[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k && j < length; j++) {
                    if (j < 0) {
                        continue;
                    }
                    if (done[j] == false) {
                        done[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        
    }
}
