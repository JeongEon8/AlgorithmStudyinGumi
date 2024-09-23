import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = 0;

        int[] loc = new int[100001];

        // N부터 시작해서 -1, +1, *2씩 움직이면서 도달하는 지점 찾기

        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        while(queue.size() != 0) {
            int q = queue.poll();
            if(q == K) {
                queue.clear();
                time = loc[q];
            }else{
                if(checkRange(q-1) == true && loc[q-1] == 0) {
                    queue.add(q-1);
                    loc[q-1] = loc[q] + 1;
                }
                if(checkRange(q+1) == true && loc[q+1] == 0){
                    queue.add(q+1);
                    loc[q+1] = loc[q] + 1;
                }
                if(checkRange(q*2) == true && loc[q*2] == 0) {
                    queue.add(q*2);
                    loc[q*2] = loc[q] + 1;
                }
            }
        }

        System.out.println(time);
    }
    static boolean checkRange(int i){
        if(i < 0 || i > 100000) return false;
        else return true;
    }
}
