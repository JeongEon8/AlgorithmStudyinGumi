import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Solution {
 
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int square;
 
        public Node(int x, int y, int square) {
            this.x = x;
            this.y = y;
            this.square = square;
        }
 
        @Override
        public int compareTo(Node o) {
            if(this.square > o.square) return 1;
            else if(this.square == o.square && this.x > o.x) return 1;
            else return -1; 
        }
    }
 
    static int answer = 0;
    static ArrayList<int[]> matrixs = new ArrayList<>();
    static int[][] maps;
    static boolean[][] visited;
    static int N;
    static int largeX = 0;
    static int largeY = 0;
 
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(bf.readLine());
 
        int T = Integer.parseInt(st.nextToken()); // 테케 개수
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            maps = new int[N][N];
            visited = new boolean[N][N];
 
            init();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(maps[i][j] != 0 && visited[i][j] == false) {
 
                        visited[i][j] = true;
                        dfs(i, j);
                        int[] tmp = {largeX-i,largeY-j};
                        matrixs.add(tmp);
                        answer += 1;
                        largeX = 0;
                        largeY = 0;
                    }
                }
            }
            String answerStr = answer+" ";
            PriorityQueue<Node> pQueue = new PriorityQueue<>();
            for (int i = 0; i < matrixs.size(); i++) {
                pQueue.add(new Node(matrixs.get(i)[0]+1, matrixs.get(i)[1]+1,(matrixs.get(i)[0]+1)*(matrixs.get(i)[1]+1)));
            }
            while(pQueue.size() != 0) {
                Node node = pQueue.poll();
                answerStr += node.x + " "+node.y + " ";
            }
 
            System.out.println("#" + test_case+" "+answerStr);
 
        }
    }
 
    static void dfs(int x, int y) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
 
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(checkRange(nextX, nextY) == true && maps[nextX][nextY] != 0 && visited[nextX][nextY] == false) {
                visited[nextX][nextY] = true;
                if(nextX > largeX) {
                    largeX = nextX;
                }
                if(nextY > largeY) {
                    largeY = nextY;
                }
 
                dfs(nextX, nextY);
 
            }
        }
    }
 
    static boolean checkRange(int x, int y){
        if(x < N && x > -1 && y < N && y > -1) return true;
        else return false;
    }
     
    static void init(){
        answer = 0;
        largeX = 0;
        largeY = 0;
        matrixs = new ArrayList<>();
    }
}
