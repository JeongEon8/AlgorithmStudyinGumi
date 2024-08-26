import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        // System.setIn(new FileInputStream("./스터디/input_7465.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] relations = new ArrayList[N];
            boolean[] visited = new boolean[N];

            for (int i = 0; i < M; i++) {
              st = new StringTokenizer(bf.readLine());
              
              int per1 = Integer.parseInt(st.nextToken())-1;
              int per2 = Integer.parseInt(st.nextToken())-1;

              if(relations[per1] == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(per2);
                relations[per1] = list;
              }else{
                relations[per1].add(per2);
              }

              if(relations[per2] == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(per1);
                relations[per2] = list;
              }else{
                relations[per2].add(per1);
              }
            }

            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
              for (int i = 0; i < N; i++) {
                if(relations[i] != null && visited[i] == false) {
                  queue.add(i);
                  count += 1;
                  visited[i] = true;
                  while(queue.size() != 0) {
                    int p = queue.poll();
                    for (int j = 0; j < relations[p].size(); j++) {
                        if(visited[relations[p].get(j)] == false){
                          queue.add(relations[p].get(j));
                          visited[relations[p].get(j)] = true;
                        }
                    }
                  }
                }
              }
      
            for (int i = 0; i < visited.length; i++) {
                if(visited[i] == false) count += 1;
            }
            System.out.println("#"+test_case+" "+count);
            
        }
    }
}
