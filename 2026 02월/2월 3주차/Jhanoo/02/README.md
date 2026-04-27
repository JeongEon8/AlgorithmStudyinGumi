# [백준 - 골드 4] 2473. 세 용액

## ⏰**time**

28분

## :pushpin: **Algorithm**

- 정렬
- 투 포인터 (Three Pointers)

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 입력 받은 용액 특성값들을 배열에 저장하고 오름차순으로 정렬합니다.

```java
long[] a = new long[N];
// 입력 ...
Arrays.sort(a);
```

2. 모든 용액이 **음수**이거나 **양수**인 경우는 예외 처리로 빠르게 답을 구할 수 있습니다.
   - 모두 음수라면 가장 큰(0에 가까운) 세 값을 선택
   - 모두 양수라면 가장 작은 세 값을 선택

```java
if (a[N - 1] < 0) {
    System.out.println(a[N - 3] + " " + a[N - 2] + " " + a[N - 1]);
    return;
} else if (a[0] > 0) {
    System.out.println(a[0] + " " + a[1] + " " + a[2]);
    return;
}
```

3. 나머지 경우에는 하나의 기준 인덱스 `i`를 고정하고, 그 오른쪽 구간에서 두 포인터 `l`, `r`을 사용해 세 용액의 합이 0에 가장 가까운 조합을 찾습니다.

```java
long minAbs = Long.MAX_VALUE;
int n1 = -1, n2 = -1, n3 = -1;
for (int i = 0; i < N - 2; i++) {
    int l = i + 1;
    int r = N - 1;
    while (l < r) {
        long sum = a[i] + a[l] + a[r];
        long sumAbs = Math.abs(sum);
        if (sumAbs < minAbs) {
            minAbs = sumAbs;
            n1 = i; n2 = l; n3 = r;
        }
        if (sum > 0) r--;
        if (sum < 0) l++;
        if (sum == 0) {
            System.out.println(a[i] + " " + a[l] + " " + a[r]);
            return;
        }
    }
}
```

4. 모든 경우를 탐색한 후, 기록해 둔 인덱스 `n1, n2, n3`에 해당하는 세 용액을 출력하면 된다.

```java
System.out.println(a[n1] + " " + a[n2] + " " + a[n3]);
```

## :black_nib: **Review**

- 세 용액을 골라야 하므로 한 용액을 고정하고 나머지 두 용액을 투 포인터로 찾았다.

## 📡 Link

https://www.acmicpc.net/problem/2473
