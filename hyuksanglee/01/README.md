# [PGS - Lv2] 01_바이러스 파이프

## ⏰**time**

- 40분

## :pushpin: **Algorithm**
- 트리
- 중복 순열


## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 인접 리스트로 숫자와 타입을 넣어준다
2. 중복 순열을 이용해서 하나씩 시뮬레이션 해주고 마지막에 개수를 비교해서 계산해준다.
   ```
   private void dfs(
            int depth,
            int prevType,
            boolean[] infected,
            int count
    ) {

        answer = Math.max(answer, count);

        if (depth == k) {
            return;
        }

        for (int type = 1; type <= 3; type++) {

            if (type == prevType) {
                continue;
            }

            boolean[] nextInfected = infected.clone();

            int nextCount = spread(type, nextInfected, count);

            dfs(
                    depth + 1,
                    type,
                    nextInfected,
                    nextCount
            );
        }
    }

    private int spread(
            int type,
            boolean[] infected,
            int count
    ) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (Edge edge : graph[current]) {

                if (edge.type != type) {
                    continue;
                }
                if (infected[edge.next]) {
                    continue;
                }

                infected[edge.next] = true;
                count++;

                queue.offer(edge.next);
            }
        }

        return count;
    }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/468373
