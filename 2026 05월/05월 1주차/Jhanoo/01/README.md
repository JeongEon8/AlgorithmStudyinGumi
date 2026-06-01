# [프로그래머스 - Lv2] 최솟값 만들기

## ⏰**time**

5분

## :pushpin: **Algorithm**

- 정렬
- 그리디

## ⏲️**Time Complexity**

$O(N \log N)$  
(\(N\): 배열 길이, 정렬이 지배)

## :round_pushpin: **Logic**

1. 한 배열은 오름차순, 다른 배열은 내림차순으로 맞추면 곱의 합이 최소가 된다. (재배열 부등식)  
   여기서는 `A`를 오름차순, `B`도 오름차순으로 정렬한 뒤 `A[i]`와 `B[n-1-i]`를 짝지어 곱한다.

```java
Arrays.sort(A);
Arrays.sort(B);
```

2. 같은 인덱스끼리 곱해 누적하면, 작은 값은 큰 값과, 큰 값은 작은 값과 곱해지는 형태가 된다.

```java
for (int i = 0; i < n; i++) {
    sum += A[i] * B[n - i - 1];
}
```

3. 누적한 `sum`을 반환한다.

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12941
