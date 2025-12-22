import java.io.*;
import java.util.*;

class Main{
    static int[] min;
    static int[] max;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[][] maps = new int[N][3];
        min = new int[3];
        max = new int[3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            maps[i][0] = Integer.parseInt(st.nextToken());
            maps[i][1] = Integer.parseInt(st.nextToken());
            maps[i][2] = Integer.parseInt(st.nextToken());
        }

        init(maps);

        for(int i = 1; i < N; i++) {
            int[] copyMin = min.clone();
            int[] copyMax = max.clone();
            for(int j = 0; j < 3; j++) {
                int minVal = Integer.MAX_VALUE;
                int maxVal = 0;
                int start = j - 1 >= 0 ? j-1: 0;
                int end = j + 1 < 3 ? j + 1 : 2;

                for(int k = start; k <= end; k++) {
                    minVal = Math.min(minVal, maps[i][j] + min[k]);
                    maxVal = Math.max(maxVal, maps[i][j] + max[k]);
                }
                copyMin[j] = minVal;
                copyMax[j] = maxVal;
            }
            min = copyMin.clone();
            max = copyMax.clone();
        }
        int minAns = Math.min(min[0], min[1]);
        minAns = Math.min(minAns, min[2]);

        int maxAns = Math.max(max[0], max[1]);
        maxAns = Math.max(maxAns, max[2]);

        System.out.println(maxAns+" "+minAns);
    }

    public static void init(int[][] maps) {
        min[0] = maps[0][0];
        min[1] = maps[0][1];
        min[2] = maps[0][2];

        max[0] = maps[0][0];
        max[1] = maps[0][1];
        max[2] = maps[0][2];
    }
}
