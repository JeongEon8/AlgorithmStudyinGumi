import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;


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
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                }
            }
            int sr = 0;
            int sc = 0;
            PriorityQueue<Cost> queue = new PriorityQueue<>((c1, c2) -> 
            Integer.compare(c1.getTime(), c2.getTime()));

            queue.add(new Cost(sr,sc,0));

            while (queue.size()!=0) {
                Cost p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int dr =  p.row + row[i];
                    int dc =  p.col + col[i];
                    if (0<=dc && dc<size && 0<=dr && dr<size){
                        if (visited[dr][dc] == false){
                            visited[dr][dc] = true;
                            queue.add(new Cost(dr,dc,p.time + arr[dr][dc]));
                            if (dr == size -1 && dc == size-1){
                                queue.clear();
                                answer = p.time + arr[dr][dc];
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}
class Cost{
    int row;
    int col;
    int time;

    Cost(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }

    public int getTime(){
        return time;
    }
}