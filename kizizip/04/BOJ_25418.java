import java.util.*;
public class BOJ_25418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int k = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[k+1];

        q.add(new int[]{a,0});
        visited[a] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];

            if(num==k){
                System.out.println(cnt);
                return;
            }

            if(num+1<=k && !visited[num+1]){
                visited[num+1] = true;
                q.add(new int[]{num+1, cnt+1});
            }
            if(num*2<=k && !visited[num*2]){
                visited[num*2] = true;
                q.add(new int[]{num*2, cnt+1});
            }
        }
    }
}
