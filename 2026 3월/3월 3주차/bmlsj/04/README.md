# [백준 - 실버5] 11256. 사탕

## ⏰ **time**

30분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N \log N)$

## :round_pushpin: **Logic**

1. 상자를 크기 기준으로 오름차순 정렬
2. 가장 큰 상자부터 하나씩 선택
3. 선택한 상자들의 누적 합이 사탕 개수 J 이상이 되는 순간 종료

```java
// 오름차순 정렬
Arrays.sort(boxes);

int total = 0;
int count = 0;

// 큰 상자부터 선택
for (int i = N - 1; i >= 0; i--) {
    total += boxes[i];
    count++;

    if (total >= J) break;
}
```

## :black_nib: **Review**

## 📡**Link**

<https://www.acmicpc.net/problem/11256>
