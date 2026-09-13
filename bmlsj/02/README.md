# [PGS - LV3] 02\_입국심사

## ⏰**time**

30분

## :pushpin: **Algorithm**

이분탐색

## ⏲️**Time Complexity**

$O(N\logN)$

## :round_pushpin: **Logic**

1. 탐색 범위를 최소 시간 `left = 1`부터 최대 시간 `right = (long) times[times.length - 1] * n`으로 설정
2. `left <= right` 동안 중간 시간을 구하고, 모든 심사관이 해당 시간 동안 처리할 수 있는 총 인원수(`sum += mid / time`)를 계산
3. `sum < n`: 시간 mid 동안 $N$명을 처리할 수 없으므로, 더 긴 시간이 필요함 (`left = mid + 1`)
4. `sum >= n`: 시간 mid 동안 $N$명 이상 처리가 가능하므로 정답 후보로 `answer = mid` 저장 후, 더 짧은 시간으로도 가능한지 검증 (`right = mid - 1`)

```java
Arrays.sort(times);

long left = 1;
long right = (long) times[times.length - 1] * n;

while(left <= right) {

    long mid = (left + right) / 2;
    long sum = 0;

    for(int time: times) {
        sum += mid / time;
    }

    if (sum < n) {
        left = mid + 1;
    } else {
        answer = mid;
        right = mid - 1;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/43238>
