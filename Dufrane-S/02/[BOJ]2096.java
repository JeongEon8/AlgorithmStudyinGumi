import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sNext = new int[3];
        int[] lNext = new int[3];
        int[] sList = new int[3];
        int[] lList = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sList[i] = temp;
            lList[i] = temp;
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sNext[j] = tmp;
                lNext[j] = tmp;
            }
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 0; k < 2; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;

                } else if (j == 1) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;
                } else if (j == 2) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 1; k < 3; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;
                }

            }
            for (int k = 0; k < 3; k++) {
                sList[k] = sNext[k];
                lList[k] = lNext[k];
            }
            
        }
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (lList[i] > large) large = lList[i];
            if (sList[i] < small) small = sList[i];
        }

        bw.write(Integer.toString(large));
        bw.write(' ');
        bw.write(Integer.toString(small));
        bw.flush();
        bw.close();
    }
}
