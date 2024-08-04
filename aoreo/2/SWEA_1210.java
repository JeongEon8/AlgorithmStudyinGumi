import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.awt.Point;;


class Solution1210
{
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("1210/input_1210.txt"));

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int tc = sc.nextInt();
            int[][] ladder = new int[100][100];
			      for(int i = 0; i < 100; i++) {
              for (int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }
            int answer = -1;

            Queue<Point> queue = new LinkedList<>();

            for (int i = 0; i < 100;i++){
              if (answer != -1) break;
                boolean[][] visited = new boolean[100][100];
                if (ladder[0][i] == 1) {
                  queue.add(new Point(0,i));
                  visited[0][i] = true;
  
                  while (queue.size() != 0) {
                      Point p = queue.poll();
                      int cr = p.x;
                      int cc = p.y;
      
                      // 오른쪽이나 왼쪽으로 이동이 가능하면 이동
                      // 그 후 아래로 이동
                      if (cc+1 < 100 && ladder[cr][cc+1] == 1 && visited[cr][cc+1] == false) { // 오른쪽으로 이동
                          queue.add(new Point(cr, cc+1));
                          visited[cr][cc+1] = true;
                      } else if (cc -1 >=0 && ladder[cr][cc-1] == 1 && visited[cr][cc-1] == false){ // 왼쪽으로 이동
                          queue.add(new Point(cr, cc-1));
                          visited[cr][cc-1] = true;
                      } else {
                        if(cr + 1 != 99){// 내려갈 길밖에 없음
                          queue.add(new Point(cr+1,cc));
                          visited[cr+1][cc] = true;
                        }else{
                          if (ladder[cr+1][cc] == 2) answer = i;
                        }
                      }
                  }
                }

            }
            System.out.println("# "+tc+" "+answer);
		}
	}
}