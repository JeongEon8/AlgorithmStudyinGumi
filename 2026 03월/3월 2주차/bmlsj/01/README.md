# [백준 - 실버 5] 1476. 날짜 계산

## ⏰**time**

약 20분

## :pushpin: **Algorithm**

Brute Force

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 입력받은 E, S, M 값을 기준으로 year를 1부터 증가시키며 탐색한다.
2. 각 year에 대해 다음과 같이 나머지 연산을 이용해 현재 값을 계산한다.
   - `e = year % 15`
   - `s = year % 28`
   - `m = year % 19`
3. 나머지 연산의 결과가 0이면 각각의 최대값으로 변환한다.
   - `e == 0 → 15`
   - `s == 0 → 28`
   - `m == 0 → 19`
4. 계산된 `(e, s, m)` 값이 입력 `(E, S, M)`과 같아지는 순간의 `year`를 출력한다.
5. 세 수의 최대 공배수는 7980이므로 최악의 경우에도 7980번 이내에 정답을 찾을 수 있다.

```java
int year = 1;
while(true) {

   int e = year % 15;
    int s = year % 28;
    int m = year % 19;

    if (e == 0) e = 15;
    if (s == 0) s = 28;
    if (m == 0) m = 19;

    if (e == E && s == S && m == M) {
        System.out.println(year);
        break;
    }

    year++;
}
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/1476>
