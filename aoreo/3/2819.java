import java.awt.Point;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Solution
{

  static int[] row = {1,-1,0,0};
  static int[] col = {0,0,-1,1};

  static String [][] arr = new String[4][4];

  static Set<String> set = new HashSet<>();

	public static void main(String args[]) throws Exception
	{

   //  System.setIn(new FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            set = new HashSet<String>();
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          arr[i][j] = sc.next();
        }
      }

      for(int i = 0; i <4; i++){
        for (int j=0; j< 4; j++){
          dfs(new Point(i,j), arr[i][j], 0);
          // System.out.println(set);
        }
      }
      System.out.println("#"+test_case+" "+set.size());
		}
	}

  static void dfs(Point start, String str, int depth){
    String tmp = str; // dfs로 돌면서 가능한 tmp를 반환하기

    if (depth == 6) {
      set.add(tmp);
      return;
    }

    for(int i = 0; i < 4; i++){
      int curX = start.x + row[i];
      int curY = start.y + col[i];

      if (curX >= 0 && curX < 4 && curY >= 0 && curY < 4) {
          dfs(new Point(curX, curY), tmp + arr[curX][curY], depth+1);
      }
    }
  }
}
