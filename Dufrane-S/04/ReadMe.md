# [백준 - G5] 17070. 파이프 옮기기 1
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. bfs를 통해 이동의 경우의 수를 모두 카운트
```
 while (!q.empty()) {
        pair<int, int> tail = q.front().first;
        pair<int, int> head = q.front().second;
        q.pop();
        if (head.first == n - 1 && head.second == n - 1) {
            answer++;
            continue;
        }
        if (tail.first == head.first && head.second - tail.second == 1) {// 가로
            if (head.second + 1 != n) {
                if (box[head.first][head.second + 1] == 0) {
                    q.push({{head.first, head.second},
                            {head.first, head.second + 1}});
                }
                if (head.first + 1 != n && box[head.first][head.second + 1] == 0 &&
                    box[head.first + 1][head.second + 1] == 0 &&
                    box[head.first + 1][head.second] == 0) {
                    q.push({{head.first,     head.second},
                            {head.first + 1, head.second + 1}});
                }
            }
        } else if (tail.second == head.second && head.first - tail.first == 1) { //세로
            if (head.first + 1 != n) {
                if (box[head.first + 1][head.second] == 0) {
                    q.push({{head.first,     head.second},
                            {head.first + 1, head.second}});
                }
                if (head.second + 1 != n && box[head.first + 1][head.second] == 0 &&
                    box[head.first + 1][head.second + 1] == 0 &&
                    box[head.first][head.second + 1] == 0) {
                    q.push({{head.first,     head.second},
                            {head.first + 1, head.second + 1}});
                }
            }
        } else if (head.first - tail.first == 1 && head.second - tail.second == 1) { //대각
            if (head.second + 1 != n && box[head.first][head.second + 1] == 0) {
                q.push({{head.first, head.second},
                        {head.first, head.second + 1}});

            }
            if (head.first + 1 != n && box[head.first + 1][head.second] == 0) {
                q.push({{head.first,     head.second},
                        {head.first + 1, head.second}});
            }
            if (head.first + 1 != n && head.second + 1 != n && box[head.first + 1][head.second + 1] == 0 &&
                box[head.first + 1][head.second] == 0 && box[head.first][head.second + 1] == 0) {
                q.push({{head.first,     head.second},
                        {head.first + 1, head.second + 1}});
            }
        }
```

## :black_nib: **Review**
- .



## 📡 Link
https://www.acmicpc.net/problem/17070
