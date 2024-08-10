# [백준] 2491. 수열
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
ms

## :round_pushpin: **Logic**
1. result = 현재 탐색 중인 증가 or 감소 부분 길이, j = 현재 비교 중인 인덱스
```java
for (int i = 0; i < N; i++) {
    int result = 1;
    int j = i;

```

2. 인덱스 j의 요소가 다음 인덱스의 요소보다 작거나 같은 경우 j, result 각각 1씩 증가
3. result가 maxLength보다 크거나 같으면 maxLength 갱신
```java
while (j < N - 1 && arr[j] <= arr[j + 1]) {
    j++;
    result++;
    if (result >= maxLength) {
        maxLength = result;
    }
}

```

4. 감소하는 부분 탐색
```java
result = 1;
j = i;
while (j < N - 1 && arr[j] >= arr[j + 1]) {
    j++;
    result++;
    if (result >= maxLength) {
        maxLength = result;
    }
}
```


## :black_nib: **Review**
- 코드를 다 짜놨는데, '시간 초과' 문제 때문에 DP를 사용해야 한다는 사실을 늦게 알았다. ㅠㅠ... 정답은 나중에......

## 📡**Link**
- https://www.acmicpc.net/problem/2491
