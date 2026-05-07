# [PGS - lv3] 03. 여행경로

## ⏰**time**

60분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 출발 공항별로 이동 가능한 도착 공항들을 Map 형태로 저장한다.
2. 알파벳 순으로 우선 탐색해야 하므로 각 도착 리스트를 정렬한다.'
3. `ICN`에서 시작 -> DFS에서 현재 공항을 경로(path)에 추가한다.
4. 사용한 티켓 수가 전체 티켓 수와 같으면 모든 티켓을 사용한 것이므로 탐색 종료.
5. 다음 공항으로 이동할 때 해당 티켓을 리스트에서 제거하여 사용 처리한다.
6. 탐색이 끝나면 다시 리스트에 복구하여 다른 경로도 탐색한다.

```java
static void dfs(String now, int used) {

    if (finished) {
        return;
    }

    path.add(now);

    if (used == ticketCount) {
        finished = true;
        return;
    }

    if (routes.containsKey(now)) {

        List<String> nextList = routes.get(now);

        for (int i = 0; i < nextList.size(); i++) {

            String next = nextList.get(i);

            nextList.remove(i);
            dfs(next, used + 1);
            if (finished) return;
            nextList.add(i, next);

        }
    }
    path.remove(path.size() - 1);
}
```

## :black_nib: **Review**

백트래킹 사이에서 return 처리를 한번더 해줘야 한다.

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/43164>
