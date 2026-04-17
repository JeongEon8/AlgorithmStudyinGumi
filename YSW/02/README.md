# [백준 - S1] 1991. 트리 순회 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 트리
- 재귀

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이 문제는 트리의 전위 중위 후위 순회를 출력하는 문제였다.
Node 배열을 만들어 알파벳 A 부터 Z 까지 미리 생성해 두고 입력값에 따라 부모노드의 left와 right 포인터에 해당 자식 노드의 참조를 연결하여 트리를 구성하고,

전위 : 루트 > 왼쪽자식 > 오른쪽 자식
중위 : 왼쪽자식 > 루트 > 오른쪽 자식
후위 : 왼쪽자식 > 오른쪽 자식 > 루트

이 순으로 하기 때문에 재귀를 이용한 순회하는 방식으로 문제를 풀었다.

```java
	public static void preorder(Node node) {
		if (node != null) {
			sb.append(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			sb.append(node.data);
			inorder(node.right);
		}
	}

	public static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			sb.append(node.data);
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1991
