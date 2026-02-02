import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Node {
	int value;
	int index;

	Node(int value, int index) {
		this.value = value;
		this.index = index;
	}
}

public class BOJ_32185 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(0).append(" ");
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		Node[] nodes = new Node[N];

		inputs = br.readLine().split(" ");
		int V = Integer.parseInt(inputs[0]);
		int P = Integer.parseInt(inputs[1]);
		int S = Integer.parseInt(inputs[2]);
		int myStats = V + P + S;
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			V = Integer.parseInt(inputs[0]);
			P = Integer.parseInt(inputs[1]);
			S = Integer.parseInt(inputs[2]);
			nodes[i] = new Node(V + P + S, i);
		}

		Arrays.sort(nodes, Comparator.comparingInt((Node node) -> node.value).reversed());

		int count = 1;
		for (int i = 0; i < N; i++) {
			if (count == M) {
				break;
			}

			if (myStats >= nodes[i].value) {
				sb.append(nodes[i].index + 1).append(" ");
				count++;
			}
		}

		System.out.println(sb.toString().trim());
	}
}