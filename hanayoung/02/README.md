# [SWEA - D3] 02_[S W 문제해결 기본] 1일차 - View

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 빌딩들의 높이 담기
   ```
        std::vector<int> buildings(N);
        for (int i = 0; i < N; i++) {
            std::cin >> buildings[i];
        }
   ```
2. 건물들이 존재하는 2번째부터 N-3까지 확인, 주변 2 거리 건물들 중 최댓값을 찾아서 해당 높이만큼을 i번째 빌딩의 높이에서 뺀 값을 answer에 더하기, 음수일 경우는 0이 되도록 max 사용
```
        for (int i = 2; i < N - 2; i++) {
            int tallestNeighbor = std::max({buildings[i - 2], buildings[i - 1], buildings[i + 1], buildings[i + 2]});
            answer += std::max(0, buildings[i] - tallestNeighbor);
        }
```

## :black_nib: **Review**

- 최댓값 구하는 거라고 생각하는 데 좀 걸렸당...

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
