import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static class Top {
		int height, idx;
		Top(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] split = br.readLine().split(" ");
		
		Stack<Top> st = new Stack<>();
		int[] result = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}	
		
		for(int i = 0; i < N; i++) {
			// 현재 탑 보다 낮은 탑들을 pop
			while (!st.isEmpty() && st.peek().height <= arr[i]) {
				st.pop();
			}
			
			if (!st.isEmpty()) {
				result[i] = st.peek().idx;
			} else {
				result[i] = 0;
			}
			
			st.push(new Top(arr[i], i + 1));
		}
		
		for(int num: result) {
			System.out.print(num + " ");
		}
		
	}
}