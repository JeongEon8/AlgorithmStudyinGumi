# [PGS - Lv2] 02\_기지국 설치

## ⏰**time**

60min

## :pushpin: **Algorithm**

구현, 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

처음 4G 기지국들이 덮는 구간 사이 빈 공간의 길이를 계산하는 문제

- `필요 기지국 수 = (빈 구간 길이 + 커버 범위(3) - 1) / 커버범위` 이다.

- `1~2`, `6~9`면 각 길이가 2, 4이고
- 2칸이면 ceil(2 / 3) = 1개
- 4칸이면 ceil(4 / 3) = 2개

```java
class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;

        int start = 1;

        for (int stat : stations) {
            int left = stat - w;

            if (start < left) {
                int len = left - start;
                answer += (len + cover - 1) / cover;
            }

            start = stat + w + 1;
        }

        if (start <= n) {
            int len = n - start + 1;
            answer += (len + cover - 1) / cover;
        }
        return answer;
    }
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/12979>
