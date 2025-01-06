import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;
import java.io.FileInputStream;


class Main
{
	public static void main(String args[]) throws Exception
	{

        // System.setIn(new FileInputStream("1249/input_1249.txt"));
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
    int width = scanner.nextInt();

    Character[][] arr = new Character[height][width];
    Point p = new Point(); // null로 초기화 X (0,0)으로 초기화됨
    for(int i = 0; i< arr.length; i++) {
      String str = scanner.next();
      for(int j=0; j< arr[0].length;j++) {
        arr[i][j] = str.charAt(j);
        // if (arr[i][j].equals('L')  && p.equals(new Point(0,0))) p = new Point(i,j);
      } // p == new Point(0,0)은 말이 안됨, 객체와 객체를 비교했을 때 같을 수 없기 때문에 원하는 논리대로 안됨.
    }

    int[] row = {1,-1,0,0};
    int[] col = {0,0,1,-1};
    
    int max = 0;

    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 'L'){
          Queue<Point> queue = new LinkedList<>();
          int[][] visited = new int[height][width];
          queue.add(new Point(i,j));
          visited[i][j] = 1;
          
          while(queue.size() != 0) {
            Point start = queue.poll();
            for(int k = 0; k<4; k++){
              int nextX = start.x + row[k];
              int nextY = start.y + col[k];
              if(nextX > -1 && nextX < height && nextY > -1 && nextY < width && visited[nextX][nextY] == 0 && arr[nextX][nextY] == 'L'){
                queue.add(new Point(nextX, nextY));
                visited[nextX][nextY] = visited[start.x][start.y] + 1;
                if (max < visited[nextX][nextY]) max = visited[nextX][nextY];
              }
            }
          }
        }
        
      }
    }

    System.out.println(max-1);
		}
}
