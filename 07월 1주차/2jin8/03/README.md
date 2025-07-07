# [백준- S1] 1991. 트리 순회
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
트리

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 트리의 구조를 나타내기 위해 HashMap & Node 클래스(left, right) 사용
  - key: `노드 이름 - 'A'`
  - value: `new Node(left, right)`
```java
for (int i = 1; i <= N; i++) {
    String[] nodes = br.readLine().split(" ");
    char parent = nodes[0].charAt(0);
    char left = nodes[1].charAt(0);
    char right = nodes[2].charAt(0);

    if (left != '.') degree[left - 'A']++;
    if (right != '.') degree[right - 'A']++;

    trees.put(parent - 'A', new Node(left, right));
}

// 루트 노드 찾기
int root = -1;
for (int i = 0; i < M; i++) { // i: char - 'A'
    if (degree[i] == 0) {
        root = i;
        break;
    }
}
```

## :black_nib: **Review**
문제 잘 읽기,,

## 📡**Link**
- https://www.acmicpc.net/problem/1991
