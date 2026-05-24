# [PGS - Lv3] 01\_양과 늑대

## ⏰**time**

60min

## :pushpin: **Algorithm**

DFS, backtracking

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

1. 트리 생성

- `edges` 로 각 부모 노드가 가진 자식 노드를 리스트로 생성

2. 방문 노드가 양이면 `sheep + 1`, 늑대면 `wolf + 1`
3. 늑대 수가 양 이상이면 멈춤
4. 현재 갈 수 있는 `nextNodes` 중 이동할 노드 `next`를 선택
   - `next`가 갈 수 있는 자식 노드들(기존 후보들 + next의 자식들)을 추가해 새로운 후보 리스트를 만들어 dfs 호출

```java
public void dfs(int curNode, int sheep, int wolf, List<Integer> nextNodes, int[] info) {

    if (info[curNode] == 0) {
        sheep += 1;
    } else {
        wolf += 1;
    }

    if (wolf >= sheep) {
        return;
    }

    if (maxSheep < sheep) {
        maxSheep = sheep;
    }

    for(int next: nextNodes) {

        List<Integer> copy = new ArrayList<>(nextNodes);
        copy.remove(Integer.valueOf(next));

        for(int child: tree[next]) {
            copy.add(child);
        }

        dfs(next, sheep, wolf, copy, info);

    }

}
```

## :black_nib: **Review**

- `remove(int index)` : 특정 인덱스(위치)에 있는 원소를 지운다.
- `remove(Object o)` : 특정 값(데이터)을 찾아서 지운다.

2가지가 있으므로, 값을 지우기 위해서는 `Integer.valueOf(next)` 객체로 감싸줘야함.

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/92343>