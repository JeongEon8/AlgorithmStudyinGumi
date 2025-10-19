# [백준 - G5] 1068. 트리

## ⏰  **time**
30분

## :pushpin: **Algorithm**
트리

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 부모를 인덱스로 갖는 리스트 초기화, 부모를 가리키는 배열 생성
```java
        List<Integer>[] tree = new ArrayList[N];
        int[] parents = new int[N];

        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
```
2. 부모가 -1보다 큰 경우(루트가 아닌 경우) 리스트에 본인 추가하고 parents값 업데이트
```java
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent > -1) {
                tree[parent].add(i);
            }
            parents[i] = parent;
        }
```
3. 본인이 루트가 아닌 경우, 부모의 자식노드 중 본인 삭제하기
```java
if(parents[removeNode] > -1) tree[parents[removeNode]].remove(Integer.valueOf(removeNode)); // 삭제할 노드가 루트가 아닌 경우

```
4. 노드 하나씩 꺼내면서, 본인 자식 노드 큐에 추가 후, 노드 null로 변경
```java
        while(q.size() > 0) {
            int node = q.poll();
            if(tree[node] != null) {
                for(int next: tree[node]) {
                    q.add(next);
                }
            }
            tree[node] = null;
        }
```
5. tree가 null이 아니고, size가 0인 경우가 자식노드가 없는 경우(리프노드)이므로, answer 1증가
```java
        for(int i = 0; i < N; i++) {
            if(tree[i] != null && tree[i].size() == 0) answer++;
        }
```


## :black_nib: **Review**
- 트리랑 친해지기 ! 부모의 자식에서 삭제하는 걸 생각못해서 좀 더 걸려버림..

## 📡**Link**
- https://www.acmicpc.net/problem/1068
