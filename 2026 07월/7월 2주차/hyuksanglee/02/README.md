# [PGS - Lv2] 02_숫자 변환하기

## ⏰**time**

30분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 큐에 3가지 계산을 넣고 하나씩 뽑아서 값이 작으면 다시 계산해서 큐에 넣고 같은 값이 나올때까지 반복
   ```
        while (!que.isEmpty()) {
            Info info = que.poll();
            int nTotal = info.total;
            int nCount = info.count;
            
            int[] nextMoves = {nTotal + n, nTotal * 2, nTotal * 3};
            
            for (int next : nextMoves) {
                if (next == y) {
                    return nCount + 1;
                }
                
                if (next < y && !visited[next]) {
                    visited[next] = true;
                    que.add(new Info(nCount + 1, next));
                }
            }
        }
   ```

## :black_nib: **Review**

- 3가지 계산 하는 방법이 지금은 중복되지만 함수로 따로 뽑아내면 중복성 제거가 될거같음

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154538
