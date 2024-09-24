# [백준 - G5] 17070. 파이프 옮기기 1
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. bfs를 통해 이동의 경우의 수를 모두 카운트
```
  while (!q.empty()) {
        int now = q.front().first;
        int depth = q.front().second;
        answer[now] = depth;
        q.pop();
        for (auto i: daum[now]) {
            before[i]--;
            if (before[i] == 0) {
                q.push({i, depth + 1});
            }
        }
    }
```

## :black_nib: **Review**
- 위상정렬 기초문제



## 📡 Link
https://www.acmicpc.net/problem/14567
