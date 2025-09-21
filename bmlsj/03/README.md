# [백준- S3] 21921. 블로그

## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. 수열의 처음 X일(연속 구간) 합을 계산하여 초기 `sum`을 구한다.
2. 이 값을 `max`와 `count`로 초기화한다.
3. 슬라이딩 윈도우를 사용하여 배열을 한 칸씩 이동하며 합을 갱신한다.
4. `새 구간 합 = 이전 합 - 이전 구간의 맨 앞 요소 + 새로 추가된 요소`
5. 갱신된 합이 현재 `max`보다 크면 `max`를 갱신하고 `count`를 1로 초기화
6. 갱신된 합이 현재 `max`와 같으면 `count`를 증가
7. 모든 구간 합을 확인 후 `max`가 0이면 `SAD` 출력, 그렇지 않으면 `max`와 `count` 출력

```java
int sum = 0;
// 처음 X일 합
for (int i = 0; i < X; i++) {
    sum += visit[i];
}
int max = sum;
int count = 1;

// 슬라이딩
for (int i = X; i < N; i++) {
    sum = sum - visit[i - X] + visit[i];
    if (sum > max) {
        max = sum;
        count = 1;
    } else if (sum == max) {
        count++;
    }
}
```


## :black_nib: **Review**

실버도.. 오래걸리는 일이란..


## 📡**Link**
- https://www.acmicpc.net/problem/21921
