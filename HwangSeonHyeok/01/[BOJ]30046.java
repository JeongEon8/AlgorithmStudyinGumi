import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String p = in.readLine();
		String q = in.readLine();
		String r = in.readLine();
		boolean isAble = true;
		int idx1 = -1, idx2 = -1;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) != q.charAt(i)) {
				idx1 = i;
				break;
			}
		}
		if (idx1 == -1)
			isAble = false;
		if (isAble) {
			for (int i = 0; i < n; i++) {
				if (q.charAt(i) != r.charAt(i)) {
					idx2 = i;
					break;
				}
			}
			if (idx2 == -1) {
				isAble = false;
			} else if (p.charAt(idx1) == r.charAt(idx2) && q.charAt(idx1) == q.charAt(idx2)) {
				isAble = false;	
			}
		}

		if (isAble) {
			System.out.println("HJS! HJS! HJS!");
		} else {
			System.out.println("Hmm...");
		}

	}

}