import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테케 개수

        for (int tc = 1; tc <= T; tc++){
            Queue<Point> queue = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 편의점 개수
            boolean[] visited = new boolean[n];
            Point[] convs = new Point[n];
            st = new StringTokenizer(bf.readLine());
            Point home = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
    
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                convs[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            
            st = new StringTokenizer(bf.readLine());
            Point festa = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            
            String answer = "sad";

            queue.add(home);

            while(queue.size() != 0){
                Point p = queue.poll();
      
                if(Math.abs(p.x-festa.x)+Math.abs(p.y-festa.y) <= 1000){
                    // 이동 가능
                    queue.clear();
                    answer = "happy";
                    break;
                }else{
                    // 편의점 찾기
                    for (int i = 0; i < n; i++) {
                        if(visited[i] == false && Math.abs(p.x-convs[i].x) + Math.abs(p.y-convs[i].y) <= 1000){
                            queue.add(new Point(convs[i].x, convs[i].y));
                            visited[i] = true;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
