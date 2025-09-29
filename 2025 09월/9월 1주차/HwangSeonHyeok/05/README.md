# [백준 - G5] 15681. 트리와 쿼리

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 그래프 탐색
- 트리
- 깊이 우선 탐색
- 트리에서의 다이나믹 프로그래밍  

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
루트로 정해진 노드부터 깊이 우선 탐색을 하면서 해당 서브트리들의 갯수를 더하면서 올라온다.
```java
static class Node {
    int parent, size, num;
    List<Integer> childs;

    public Node(int num) {
        this.num = num;
        this.parent = -1;
        this.size = 0;
        this.childs = new ArrayList<Integer>();
    }

}

static int makeTree(int current) {
    int size = 0;

    for (int connectNode : connect[nodes[current].num]) {
        if (connectNode != nodes[current].parent) {
            nodes[connectNode].parent = nodes[current].num;
            nodes[current].childs.add(connectNode);
            size += makeTree(connectNode);
        }
    }

    return nodes[current].size = size + 1;

}
```  
## :black_nib: **Review** 
문제 하단의 힌트처럼 Node를 따로 안 만들고 배열 2개로만 하는게 더 가볍고 좋았을거 같다.
## 📡**Link**
https://www.acmicpc.net/problem/15681