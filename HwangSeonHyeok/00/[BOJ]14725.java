import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static StringBuffer sb = new StringBuffer();

	static class TrieNode {
		Map<String, TrieNode> childNodes;
		int depth;
		boolean lastNode;

		public TrieNode(int depth) {
			childNodes = new HashMap<>();
			lastNode = false;
			this.depth = depth;
		}

	}

	static class Trie {
		TrieNode root = new TrieNode(0);

		void insert(String[] data) {
			TrieNode current = root;
			int n = Integer.parseInt(data[0]);
			for (int i = 1; i <= n; i++) {
				current.childNodes.putIfAbsent(data[i], new TrieNode(current.depth + 1));
				current = current.childNodes.get(data[i]);
			}
			current.lastNode = true;
		}
		
		void print(TrieNode node) {
			if(node.lastNode) return;
			String[] childStrings =  node.childNodes.keySet().toArray(new String[0]);
			Arrays.sort(childStrings);
			for(String child: childStrings) {
				for(int i = 0; i<node.depth; i++) {
					sb.append("--");
				}
				sb.append(child+"\n");
				print(node.childNodes.get(child));
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			trie.insert(split);
		}
		trie.print(trie.root);
		System.out.println(sb);
	}

}