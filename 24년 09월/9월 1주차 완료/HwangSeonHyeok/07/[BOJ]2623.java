import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Singer{
		int num, backCnt;
		List<Integer> next;
		public Singer(int num) {
			this.num = num;
			this.backCnt = 0;
			this.next = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		Singer[] singerArr = new Singer[n+1];
		for(int i = 1; i<=n;i++) {
			singerArr[i] = new Singer(i);
		}
		for(int i = 0; i<m;i++) {
			split = in.readLine().split(" ");
			for(int j =1; j<split.length-1; j++) {
				int from = Integer.parseInt(split[j]);
				int to = Integer.parseInt(split[j+1]);
				singerArr[from].next.add(to);
				singerArr[to].backCnt++;
			}
		}

		
		int cnt=0;
		Queue<Integer> q= new ArrayDeque<>();
		for(int i =1; i<=n;i++) {
			if(singerArr[i].backCnt==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int current = q.poll();
			cnt++;
			sb.append(current+"\n");
			for(int next :singerArr[current].next) {
				singerArr[next].backCnt--;
				if(singerArr[next].backCnt==0) {
					q.add(next);
				}
			}
		}
		if(cnt==n) {
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
		
	}

}