import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> save = new ArrayList<>();
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				} else if (map[i][j] ==2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
        
        visit = new boolean[chicken.size()];
        find(0, 0); //depth, start

        System.out.println(result);
		
	}


	private static void find(int depth, int start) {
		// TODO Auto-generated method stub
		
		if(depth == m) {
			int sum =0;
			for(int[] i : house) {
				int min = Integer.MAX_VALUE;
				for(int[] j : save) {
					int a = Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);
					min = Math.min(min, a);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		
		for (int i = start; i < chicken.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				save.add(chicken.get(i));
				find(depth+1, i+1);
				save.remove(save.size() - 1);
				visit[i] = false;
			}
		}
	}

}
