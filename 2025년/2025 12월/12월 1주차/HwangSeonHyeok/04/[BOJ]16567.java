import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] isDirty = new boolean[n + 2];
		int blockCnt = 0;
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			int state = Integer.parseInt(st.nextToken());
			if (state == 1) {
				isDirty[i] = true;
				if (!isDirty[i - 1])
					blockCnt++;
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 0) {
				sb.append(blockCnt).append('\n');
			} else {
				int dirtyIdx = Integer.parseInt(st.nextToken());
				if (isDirty[dirtyIdx])
					continue;
				isDirty[dirtyIdx] = true;
				blockCnt++;
				if (isDirty[dirtyIdx - 1])
					blockCnt--;
				if (isDirty[dirtyIdx + 1])
					blockCnt--;
			}
		}
		System.out.println(sb);

	}

}