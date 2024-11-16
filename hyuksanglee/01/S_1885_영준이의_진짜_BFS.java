package S_1855_영준이의_진짜_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class S_1885_영준이의_진짜_BFS {
	
	public static ArrayList<Integer>[]list;
	public static int N;
	public static int[] pa;
	public static int[] de;
	public static int[][] sparseTable;
	public static int LOG;
	
	
	
	public static long LCA(int curr, int next) {
		
		if(de[curr]<de[next]) {
			int temp = curr;
			curr = next;
			next = temp;
		}
		
		int dif = de[curr]-de[next];
		long count = 0;
		
		for(int i= LOG; i>=0; i--) {
			if(dif>=1 << i) {
				curr= sparseTable[curr][i];
				dif-=1 << i;
				count+=1 << i;
			}
		}
		
		
		 // 2. 공통 조상을 찾음
        if (curr == next) return count;

        for (int i = LOG; i >= 0; i--) {
            if (sparseTable[curr][i] != sparseTable[next][i]) {
                count += (1 << i) * 2;
                curr = sparseTable[curr][i];
                next = sparseTable[next][i];
            }
        }

        // 3. 마지막으로 부모 노드로 이동
        return count + 2;
	}
	
	public static long bfs() {
		int[] recode = new int[2];
		Queue<Integer> que = new ArrayDeque();
		que.add(1);
		long count =0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			recode[0]=recode[1];
			recode[1]=cur;
			if(cur!=1) {
				count += LCA(recode[0],recode[1]);
			}
			
			
			for(int num : list[cur]) {
				que.add(num);
			}
			
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			list = new ArrayList[N+1];
			pa = new int[N+1];
			de = new int[N+1];
			
			LOG = (int) (Math.log(N) / Math.log(2)) + 1;
		    sparseTable = new int[N + 1][LOG+1];

		    
			
			for (int i = 0; i <= N; i++) {
			    list[i] = new ArrayList<>();
			}
			
			String[] input = in.readLine().split(" ");
			pa[1]=1;
			pa[0]=1;
			for(int i = 0; i<N-1; i++) {
				int num = Integer.parseInt(input[i]);
				list[num].add(i+2);
				pa[i+2]= num;
				de[i+2]=de[num]+1;
				
			}
			
			for (int i = 1; i <= N; i++) {
		        sparseTable[i][0] = pa[i]; // 2^0 번째 부모는 바로 부모
		    }

		    for (int j = 1; j < LOG; j++) {
		        for (int i = 1; i <= N; i++) {
		            if (sparseTable[i][j - 1] != 0) {
		                sparseTable[i][j] = sparseTable[sparseTable[i][j - 1]][j - 1];
		            }
		        }
		    }
		    System.out.println("#" + t + " " + bfs());
			
//			for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(list[i].toArray()));
//			}
		}
	}

}
