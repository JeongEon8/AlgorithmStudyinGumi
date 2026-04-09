# [백준 - 골드 5] 1068. 트리

## ⏰**time**

60분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. root 노드부터 차례로 자식 노드를 확인한다.
2. root가 제거 되었으면 바로 return
3. leaf를 확인하기 위해 isLeaf를 통해 for문에 들어가면 리프 노드를 false로 변경한다.
4. 제거 되지 않은 노드 중 for문에 들어가지 않는 노드의 수가 리프 노드의 수

```java
static class Node {
    int id;
    List<Node> children = new ArrayList<>();
    boolean isDeleted = false;

    Node(int id) {
        this.id = id;
    }
}
static void countLeaf(Node node) {

 if (node.isDeleted) return;
 boolean isLeaf = true;
 for (Node next : node.children) {
  if (!next.isDeleted) {
   countLeaf(next);
   isLeaf = false;
  }
 }

 if (isLeaf) ans++;
}
```

## :black_nib: **Review**

Node에 isDeleted랑 리스트까지 다양하게 활용할 수 있다는 걸 다시 깨닫기

## 📡 Link

<https://www.acmicpc.net/problem/1068>
