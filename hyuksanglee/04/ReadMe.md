# [백준 - S1] 1991. 트리 순회
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
- 트리

## :round_pushpin: **Logic**
1. 알파벳에 'A' 뺴서 정수로 만든다.
2. 2차원 배열에서 부모정수에 왼쪽자식과 오른쪽 자식을 넣어준다.
3. 전위: 해당 정수를 출력하고 -> 왼쪽 탐색 -> 오른쪽 탐색
   중위 : 왼쪽탐색 -> 출력 -> 오른쪽 탐색
   후위 : 왼쪽 탐색 -> 오른쪽 탐색 -> 출력
   
```#java
// 전위 순회
    public static void preorder(int node) {
        if (node == -1) return;
        System.out.print((char)(node + 'A'));  // 루트
        preorder(tree[node][0]);  // 왼쪽 자식
        preorder(tree[node][1]);  // 오른쪽 자식
    }

    // 중위 순회
    public static void inorder(int node) {
        if (node == -1) return;
        inorder(tree[node][0]);  // 왼쪽 자식
        System.out.print((char)(node + 'A'));  // 루트
        inorder(tree[node][1]);  // 오른쪽 자식
    }

    // 후위 순회
    public static void postorder(int node) {
        if (node == -1) return;
        postorder(tree[node][0]);  // 왼쪽 자식
        postorder(tree[node][1]);  // 오른쪽 자식
        System.out.print((char)(node + 'A'));  // 루트
    }
```
## :black_nib: **Review**

- dfs를 풀려고 했는데 실패하더라구요ㅠㅠ

## 📡**Link**

- https://www.acmicpc.net/problem/1991
  
