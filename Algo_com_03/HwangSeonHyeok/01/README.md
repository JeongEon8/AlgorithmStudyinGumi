# [백준 - S2] 14627. 파닭파닭

## ⏰ **time**

80분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

이분 탐색으로 파닭에 넣을 파의 길이를 최대 길이를 구해준다.

```cpp
    long long left = 1, right = 1e9, mid = (left + right) / 2;;
    while (left <= right) {
        long long sum = 0L;
        long long cnt = 0L;
        for (int i = 0; i < n; i++) {
            cnt += arr[i] / mid;
        }
        if (cnt >= m) {

            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
        mid = (left + right) / 2;
    }
    //ans엔 파의 길이의 합이 들어있었음
    ans = ans - mid * m;
```

## :black_nib: **Review**

- 처음엔 답을 계산하는 방법이 달랐었는데 반례를 만들기가 너무 어려운 문제라 반례를 찾진 못했다. 답 계산하는 식을 바꾸고 풀린거 보면 원래 계산이 예외가 있었던것 같다.
- 범위가 큰데 int를 사용한 문제도 있었다. 억단위가 보이면 일단 long long을 쓰자

## 📡**Link**

- https://www.acmicpc.net/problem/14627
