# [백준 - G4] 1027. 고층 건물

## ⏰**time**
40분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
- 기준 건물(`i`)을 정하고 다른 건물들(`j`) 볼 수 있는지 확인하기
  - 두 점을 연결한 직선 구하기 ⇒ `y = ax + b`
  - i, j 사이에 존재하는 건물들(`k`)의 높이랑 `y = ax + b`에 넣은 값이랑 비교하기
    - `heights[k]`가 더 크거나 같다면 `i` 건물에서 `j` 건물을 볼 수 없음
```
for (int i = 1; i <= N; i++) {
    int x1 = i, y1 = heights[i];
    int count = 0;
    for (int j = 1; j <= N; j++) {
        if (i == j) continue;

        boolean isWatch = true;
        int x2 = j, y2 = heights[j];

        // 직선 식 구하기
        double a = ((double) (y2 - y1)) / ((double) (x2 - x1));
        double b = ((y1 + y2) - a * (x1 + x2)) / 2;

        // x = k일 때 y값이 직선보다 위에 있다면 해당 건물을 볼 수 없음
        int start = Math.min(x1, x2), end = Math.max(x1, x2);
        for (int k = start + 1; k < end; k++) {
            int x3 = k, y3 = heights[k];
            if (a * x3 + b <= y3) {
                isWatch = false;
                break;
            }
        }
        if (isWatch) count++;
    }
    answer = Math.max(answer, count);
}
```

## :black_nib: **Review**
처음에 복잡하게 기울기로 생각했는데, 그냥 직선 만들어서 높이만 확인하면 되는 문제였다

## 📡 Link
https://www.acmicpc.net/problem/1027
