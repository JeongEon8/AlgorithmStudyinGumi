# [PGS - LV3] 02\_풍선 터트리기

## ⏰**time**

30분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 특정 풍선 $X$가 끝까지 남으려면, $X$의 왼쪽에 있는 풍선들의 최솟값과 $X$의 오른쪽에 있는 풍선들의 최솟값 중 적어도 하나보다는 $X$가 작거나 같아야 한다.
   왼쪽에서의 누적 최솟값 배열과 오른쪽에서의 누적 최솟값 배열을 계산
2. 각 풍선 $a[i]$에 대해 $a[i] > leftMin[i]$ 이고 $a[i] > rightMin[i]$인 조건을 만족하면 끝까지 남길 수 없고, 그렇지 않은 경우는 1 증가

```java
int[] leftMin = new int[n];
int[] rightMin = new int[n];

// 왼쪽에서의 누적 최솟값 구하기
int min = a[0];
for (int i = 0; i < n; i++) {
    if (a[i] < min) min = a[i];
    leftMin[i] = min;
}

// 오른쪽에서의 누적 최솟값 구하기
min = a[n - 1];
for (int i = n - 1; i >= 0; i--) {
    if (a[i] < min) min = a[i];
    rightMin[i] = min;
}

int answer = 0;
for (int i = 0; i < n; i++) {
    if (a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
    answer++;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/68646>
