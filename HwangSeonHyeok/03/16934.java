import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static class TrieNode {
		Map<Character, TrieNode> children;
		int cnt;

		public TrieNode() {
			children = new HashMap<>();
			cnt = 0;
		}

	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		String insert(String word) {
			TrieNode currentNode = root;
			StringBuilder prefix = new StringBuilder();
			boolean findPrefix = false;
			char[] charArr = word.toCharArray();
			for (char c : charArr) {
				if (currentNode.children.containsKey(c)) {
					currentNode = currentNode.children.get(c);
					if (!findPrefix) {
						prefix.append(c);
					}
				} else {
					currentNode.children.put(c, new TrieNode());
					currentNode = currentNode.children.get(c);
					if (!findPrefix) {
						prefix.append(c);
						findPrefix = true;
					}
				}

			}
			currentNode.cnt++;
			if (!findPrefix && currentNode.cnt > 1) {
				prefix.append(currentNode.cnt);
			}
			return prefix.toString();
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String word = in.readLine();
			sb.append(trie.insert(word)).append('\n');
		}
		System.out.println(sb);

	}

}