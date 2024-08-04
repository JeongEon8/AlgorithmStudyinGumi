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
                    }
                }
            }
            System.out.println("#"+test_case+" "+answer);
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

    public int getTime(){
        return time;
    }
}