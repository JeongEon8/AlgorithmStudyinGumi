import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[] inputs = new int[n];
		for (int i = 0; i < n; i++) {
			inputs[i] = Integer.parseInt(in.readLine());
		}
		int[] arr = { 0, 2, 3, 5, 7, 8, 10 };
		Map<Integer, Character> iToNotes = new HashMap<>();
		iToNotes.put(0, 'A');
		iToNotes.put(2, 'B');
		iToNotes.put(3, 'C');
		iToNotes.put(5, 'D');
		iToNotes.put(7, 'E');
		iToNotes.put(8, 'F');
		iToNotes.put(10, 'G');
		for (int i = 0; i < 7; i++) {
			int start = arr[i];
			int current = start;
			boolean isAble = true;
			for (int input : inputs) {
				current = Math.floorMod(current + input, 12);
				if (!iToNotes.containsKey(current)) {
					isAble = false;
					break;
				}
			}
			if (isAble) {
				sb.append(iToNotes.get(start)).append(" ").append(iToNotes.get(current)).append("\n");

			}

		}
		System.out.println(sb);

	}

}