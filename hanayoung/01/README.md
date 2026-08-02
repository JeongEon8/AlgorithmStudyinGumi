# [SWEA - D3] 4613. 러시아 국기 같은 깃발

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. 행별 색상 개수 저장, 각 행에서 W, B, R의 개수를 미리 저장, 특정 행을 원하는 색으로 칠할 때 필요한 횟수는 M - 해당 색의 개수로 계산할 수 있
   ```
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char color;
                std::cin >> color;
                if(color == 'W') {
                    colors[i][0]++;
                } else if(color == 'B') {
                    colors[i][1]++;
                } else if(color == 'R') {
                    colors[i][2]++;
                }
            }
        }
   ```
2. 흰색과 파란색 구간을 모두 탐색
3. 각 구간의 색칠 횟수 계산, 모든 경우 중 최소 색칠 횟수를 정답으로 갱신한다.
```
for (int we = 0; we < N-2; we++) {
            for (int be = we+1; be <= N-2; be++) {
                int sum = 0;
                for(int i = 0; i <= we; i++) {
                    sum += M - colors[i][0];
                }
                for (int i = we+1; i <= be; i++) {
                    sum += M - colors[i][1];
                }
                for (int i = be+1; i < N; i++) {
                    sum += M - colors[i][2];
                }
                answer = std::min(answer, sum);
            }
        }
```

## :black_nib: **Review**

- 완전 그냥 구현구현

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
