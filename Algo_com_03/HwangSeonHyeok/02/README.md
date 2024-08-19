# [SWEA - D5] 1248. 공통조상

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 트리
- 탐색

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

각각의 Node에 parent, left, right값을 저장해서 각각의 부모를 방문해가면서 가장 먼저 나오는 공통 조상을 찾고 preorder로 탐색하면서 공통 조상의 서브트리 크기를 세준다.

```cpp
    static void findAncestor(int n1, int n2) {
        Node current = tree[n1];
        visited[n1] = true;
        while (!current.isRoot()) {
            visited[current.parent] = true;
            current = tree[current.parent];
        }

        if (visited[n2]) {
            ancestor = n2;
            return;
        } else {
            current = tree[n2];
            while (!current.isRoot()) {
                if (visited[current.parent]) {
                    ancestor = current.parent;
                    return;
                }
                current = tree[current.parent];
            }
        }

        return;
    }

    static void calSize(Node current) {
        size++;
        if (current.left != 0) {
            calSize(tree[current.left]);
        }
        if (current.right != 0) {
            calSize(tree[current.right]);
        }

```

## :black_nib: **Review**

- 어제 수업에서 트리를 배워서 푸는데 도움이 됐다.

## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
