import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.HashSet;
import java.util.Objects;

class Record {
	int S;
	int T;
	int count;

	public Record(int S, int T, int count) {
		this.S = S;
		this.T = T;
		this.count = count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Record record = (Record) o;
		return S == record.S && T == record.T;
	}

	@Override
	public int hashCode() {
		return Objects.hash(S, T);
	}
}

public class BOJ_14562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			String[] strArr = br.readLine().split(" ");
			int S = Integer.parseInt(strArr[0]);
			int T = Integer.parseInt(strArr[1]);

			Queue<Record> queue = new ArrayDeque<>();
			HashSet<Record> visited = new HashSet<>();

			Record startRecord = new Record(S, T, 0);
			queue.add(startRecord);
			visited.add(startRecord);

			while (!queue.isEmpty()) {
				Record currentRecord = queue.poll();

				if (currentRecord.S == currentRecord.T) {
					System.out.println(currentRecord.count);
					break;
				}

				// 발차기 A인 경우
				Record nextA = new Record(currentRecord.S * 2, currentRecord.T + 3, currentRecord.count + 1);
				if (!visited.contains(nextA) && nextA.S <= nextA.T) {
					queue.add(nextA);
					visited.add(nextA);
				}

				// 발차기 B인 경우
				Record nextB = new Record(currentRecord.S + 1, currentRecord.T, currentRecord.count + 1);
				if (!visited.contains(nextB) && nextB.S <= nextB.T) {
					queue.add(nextB);
					visited.add(nextB);
				}
			}
		}
	}
}