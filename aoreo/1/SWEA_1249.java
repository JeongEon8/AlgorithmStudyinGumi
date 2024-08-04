/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

import java.io.FileInputStream;
// 

class Solution
{
	public static void main(String args[]) throws Exception
	{

        System.setIn(new FileInputStream("1249/input_1249.txt"));
		Scanner scanner = new Scanner(System.in);
		int T;
		T=scanner.nextInt();

        int[] col = {0,0,1,-1};
        int[] row = {-1,1,0,0};

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            boolean[][] visited = new boolean[size][size];
            int answer = -1;
            for (int i = 0; i < size ; i++){
                String str = scanner.next();
                // System.out.println(str);
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                }
            }
            int sc = 0;
            int sr = 0;
            PriorityQueue<Cost> queue = new PriorityQueue<>((m1, m2) -> 
            Integer.compare(m1.getTime(), m2.getTime()));

            queue.add(new Cost(sr,sc,0));

            while (queue.size()!=0) {
                Cost p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int dc =  p.col + col[i];
                    int dr =  p.row + row[i];
                    // System.out.println(dr+"  "+dc);
                    if (0<=dc && dc<size && 0<=dr && dr<size){
                        if (visited[dc][dr] == false){
                            visited[dc][dr] = true;
                            queue.add(new Cost(dc,dr,p.time + arr[dc][dr]));
                            if (dr == size -1 && dc == size-1){
                                queue.clear();
                                answer = p.time + arr[dc][dr];
                                break;
                            }
                        }
                        // if (visited[dr][dc] == 0){ // not visited
                        //     visited[dr][dc] = visited[p.x][p.y] + arr[dr][dc];
                        //     // System.out.println("0  "+Arrays.deepToString(visited));
                        //     queue.add(new Cost(dr,dc,visited[dr][dc]));
                        //     if (dr == size-1 && dc == size-1 && visited[dr-1][dc] >= visited[dr][dc] && visited[dr][dc-1] >= visited[dr][dc]) {
                        //         queue.clear();
                        //         break;
                        //     }
                        // }else if(visited[dr][dc] != 0 && visited[dr][dc] > visited[p.x][p.y] + arr[dr][dc]){
                        //     visited[dr][dc] = visited[p.x][p.y] + arr[dr][dc];
                        //     // System.out.println("not 0  "+Arrays.deepToString(visited));
                        //     queue.add(new Cost(dr,dc,visited[dr][dc]));
                        //     if (dr == size-1 && dc == size-1 && visited[dr-1][dc] >= visited[dr][dc] && visited[dr][dc-1] >= visited[dr][dc]) {
                        //         queue.clear();
                        //         break;
                        //     }
                        // }
                        // if (dr > 80 || dc >80) System.out.println(Arrays.deepToString(visited));
                    }
                }
            }
            System.out.println("#"+test_case+" "+answer);
            // System.out.println(Arrays.deepToString(visited));
            // System.out.println("next TestCases");
		}
	}
}
class Cost{
    int col;
    int row;
    int time;

    Cost(int col, int row, int time) {
        this.col = col;
        this.row = row;
        this.time = time;
    }

    // @Override
    // public int compare(Cost o1, Cost o2) {
    //     if (o1.time < o2.time) return -1;
    //     else if (o1.time > o2.time) return 1;
    //     else return 0;
    // }

    public int getTime(){
        return time;
    }
}