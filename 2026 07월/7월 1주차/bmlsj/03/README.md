# [PGS - lv2] 03. 땅따먹기

## ⏰**time**

30분

## :pushpin: **Algorithm**

DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 뒤에서 두 번째 행부터 출발
2. 현재 열과 다른 열인 아래 행의 최댓값을 찾아서 더한다.
3. 0번째 행에서 최종 최댓값 반환

- 모든 연산이 끝나면 맨 꼭대기인 0번째 행(`land[0]`)에 모든 행을 거쳐 온 최종 누적 점수들이 쌓이게 됩니다.
- `land[0][0]`부터 `land[0][3]`까지의 4개 값 중 가장 큰 값을 반환

```java
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = land.length - 2; i >= 0; i--) {
            land[i][0] += Math.max(land[i + 1][1], Math.max(land[i+1][2], land[i+1][3]));
            land[i][1] += Math.max(land[i + 1][0], Math.max(land[i+1][2], land[i+1][3]));
            land[i][2] += Math.max(land[i + 1][0], Math.max(land[i+1][1], land[i+1][3]));
            land[i][3] += Math.max(land[i + 1][0], Math.max(land[i+1][1], land[i+1][2]));
        }


        return Math.max(
            Math.max(land[0][0], land[0][1]),
            Math.max(land[0][2], land[0][3])
        );
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12913>
