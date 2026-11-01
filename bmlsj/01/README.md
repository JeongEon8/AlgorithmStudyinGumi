# [PGS - LV2] 01\_프렌즈4블록

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 전체 블록을 순회하며 블록이 모두 같은 모양인지 확인
2. 조건을 만족하는 영역이 존재하면 `HashSet<Node>`에 해당 좌표들을 추가하여 동시에 중복 제거
3. 지울 블록이 더 이상 없다면 반복을 종료
4. 제거된 블록들을 맵과 보드에서 비운 뒤, 위에 있는 블록들이 아래로 떨어질 수 있도록 행 번호(x)를 기준으로 정렬 및 이동 처리

```java
while (true) {
    HashSet<Node> toRemove = new HashSet<>();
    map.forEach((key, nodes) -> {
        for (Node node : nodes) {
            if (node.x + 1 < m && node.y + 1 < n) {
                if (boards[node.x + 1][node.y].equals(key) &&
                    boards[node.x][node.y + 1].equals(key) &&
                    boards[node.x + 1][node.y + 1].equals(key)) {

                    toRemove.add(new Node(node.x, node.y));
                    toRemove.add(new Node(node.x + 1, node.y));
                    toRemove.add(new Node(node.x, node.y + 1));
                    toRemove.add(new Node(node.x + 1, node.y + 1));
                }
            }
        }
    });

    if (toRemove.size() == 0)
        break;

    map.forEach((key, nodes) -> {
        nodes.removeAll(toRemove);
    });

    for (Node node : toRemove) { // 제거한 노드들 초기화
        boards[node.x][node.y] = "";
    }

    ans += toRemove.size();
    map = fallNodes(map, m);
    updateBoards(boards, map, m, n);
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/17679>
