# [백준 - G3] 14725. 개미굴

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 자료구조
- 문자열
- 트리
- 트라이

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

깊이와 아래층 노드 정보를가진 childNodes Map, 마지막 노드임을 표시한 lastNode를 가진 트라이 노드 구조를 만든다.  
트라이엔 line단위로 데이터를 입력받아 childNodeMap에 동일한 이름이 없으면 추가하고 계속 child로 넘어가면서 삽입한다.  
출력할땐 같은 층에선 사전순으로 출력해야하므로 key순으로 정렬하고 층수만큼 "--"를 출력하고 값을 출력하면서 child로 내려간다.

```java
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
```

## :black_nib: **Review**

지금보니 정렬은 Key를 기준으로한 comparable설정하고 TreeMap사용하는게 나았을수도.  
일반적인 문자 트라이보단 트리에 더 가까웠던문제같다.  
트라이 좀 더 공부하자

## 📡**Link**

https://www.acmicpc.net/problem/14725
