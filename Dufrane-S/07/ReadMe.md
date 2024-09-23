# [백준 - S2] 11724. 연결 요소의 개수

## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. bfs를 연결 요소 구하기
```
  for (int i = 0; i < n; i++) {
        if (!done[i]) {
            done[i] = true;
            answer++;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int now = q.front();
                q.pop();
                for (auto k: box[now]) {
                    if (!done[k]) {
                        done[k] = true;
                        q.push(k);
                    }
                }
            }
        }
    }
```

## :black_nib: **Review**
- 오타🤦‍♂️



## 📡 Link
https://www.acmicpc.net/problem/11724
