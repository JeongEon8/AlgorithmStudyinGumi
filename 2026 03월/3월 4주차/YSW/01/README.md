# [백준 - S1] 9934. 완전 이진 트리 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 트리
- 재귀

## ⏲️**Time Complexity**

$O(2^K)$

## :round_pushpin: **Logic**

상근이가 완전트리 형태로 도시의 빌딩들이 주어졌을때 중위순회로 빌딩을 방문한게 주어졌을 때, 트리를 복원하는 문제였다. 완전 이진 트리의 중위 순회 배열에서 중앙값이 부모 노드라는 점을 이용해, 재귀적으로 배열을 이분 분할하며 각 층에 해당하는 노드들을 수집해 나가는 방식으로 해결했다.

```java
	public static void solve(int start, int end, int depth, int k, int[] arr, ArrayList<Integer>[] tree) {
		if (depth == k) {
			return;
		}

		int mid = (start + end) / 2;
		tree[depth].add(arr[mid]);
		solve(start, mid - 1, depth + 1, k, arr, tree);
		solve(mid + 1, end, depth + 1, k, arr, tree);
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9934
