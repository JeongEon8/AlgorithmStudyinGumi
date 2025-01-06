import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int[] sel;
	static ArrayList<Integer>[] graph;
	static int entirePop = 0;
	static int[] populations;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		answer = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		
		populations = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < populations.length; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
			entirePop += populations[i];
		}
		
//		System.out.println("populations "+Arrays.toString(populations));
//		System.out.println("entire "+entirePop);
		
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			if(graph[i] == null) graph[i] = new ArrayList<Integer>();
			for (int j = 0; j < cnt; j++) {
				int con = Integer.parseInt(st.nextToken())-1;
				if(graph[con] == null) {
					graph[con] = new ArrayList<Integer>();
				}
				graph[i].add(con);
			}
		}
		
		for (int i = 1; i <= N/2; i++) {
			sel = new int[i];
			Arrays.fill(sel, -1);
			comb(0,0,i);
		}
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	static void comb(int idx, int r, int last) {
		if(r == last) {
			// 다 뽑았당
			// 연결 여부 체크 + 인구 수 비교
			boolean result = checkConnection();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sel[r] = i;
			comb(i+1, r+1, last);
		}
	}
	
	static boolean checkConnection() {
		// 뽑은 것들로 연결성 확인?
		Queue<Integer> queue = new LinkedList<>();
		boolean isConnected = true;
		queue.add(sel[0]);
		boolean[] visited = new boolean[N];
		visited[sel[0]] = true;
		int cnt = 1;
		int pop1 = populations[sel[0]];
		while(queue.size() != 0) {
			Integer p = queue.poll();
			for(int e : graph[p]) {
				if(visited[e] == false) {
					for (int selected : sel) {
						if(selected == e) {
							visited[e] = true;
							cnt += 1;
							queue.add(e);
							pop1 += populations[e];
							break;
						}
					}
				}
			}	
		}
		queue.clear();
		if(cnt != sel.length) {
			isConnected = false;
			pop1 = 0;
		}
//		System.out.println("selected is connected? "+isConnected+" cnt "+cnt+" sel length "+sel.length);
		if(isConnected == true) {
			cnt = 1;
			
			ArrayList<Integer> other = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				other.add(i);
			}
			for (int e : sel) {
				other.remove(Integer.valueOf(e));
			}
			
			queue.add(other.get(0));
			int pop2 = populations[other.get(0)];
			
			visited = new boolean[N];
			visited[other.get(0)] = true;
			
			while(queue.size() != 0) {
				Integer p = queue.poll();
				for(int e : graph[p]) {
					if(visited[e] == false && other.contains(e)) {
						cnt += 1;
						visited[e] = true;
						queue.add(e);
						pop2 += populations[e];
					}
				}
			}
			if(cnt != other.size()) {
				isConnected = false;
				pop2 = 0;
			}
			
//			System.out.println("other set is connected? "+isConnected+" "+Math.abs(pop1-pop2));
			if(isConnected == true && pop1 != 0 && pop2 != 0 && answer > Math.abs(pop1-pop2)) {
				answer = Math.abs(pop1-pop2);
//				System.out.println("answer updated "+answer+" pop1 "+pop1+" pop2 "+pop2);
			}
		}
		
		return isConnected;
	}

}
