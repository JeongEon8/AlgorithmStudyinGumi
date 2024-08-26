import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution
{
    static int N;
    static int B;
    static int[] heights;
    static int min = Integer.MAX_VALUE;
    static HashSet<Integer> hashSet;
    static int sum = 0;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("./스터디/input_1486.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            hashSet = new HashSet();

            sum = 0;
            min = Integer.MAX_VALUE;

            for(int i = 1;i<=N;i++){
                sum = 0;
                comb(0,0,i,0);
            }
            System.out.println("tc "+test_case+" "+min);
            
        }
    }
    static void comb(int idx, int r, int depth, int sum){
        if(r == depth) {
            if(sum >= B && sum - B < min) {
                min = sum - B;
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            comb(i+1, r+1, depth, sum + heights[i]);
        }
    }
}
