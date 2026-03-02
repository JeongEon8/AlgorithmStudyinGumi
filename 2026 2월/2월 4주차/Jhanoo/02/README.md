# [백준 - 골드 2] 7453. 합이 0인 네 정수

## ⏰**time**

67분

## :pushpin: **Algorithm**

- 배열 전처리 (두 배열 합)
- 이분 탐색 (lower/upper bound)
- 투포인터/이분탐색 기반 카운팅

## ⏲️**Time Complexity**

- 두 배열 합 생성: $O(n^2)$
- 정렬: $O(n^2 \log n^2)$
- 나머지 두 배열 순회 + 이분 탐색: $O(n^2 \log n^2)$  
  → 전체: $O(n^2 \log n)$

## :round_pushpin: **Logic**

1. 입력으로 주어진 네 배열 `A, B, C, D`를 각각 길이 `n`으로 받고, `A[i] + B[j]`의 모든 조합을 한 배열 `AB`에 저장합니다.

```java
int size = n * n;
int[] AB = new int[size];
int idx = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        AB[idx++] = A[i] + B[j];
    }
}
Arrays.sort(AB);
```

2. 이제 `C[i] + D[j]`를 모두 만들지는 않고, 이중 반복문으로 `(C[i], D[j])` 쌍을 순회하면서  
   `cdSum = C[i] + D[j]`에 대해 `AB` 안에 `-(cdSum)`이 몇 개 있는지 **이분 탐색**으로 세어 줍니다.

```java
long ans = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        int cdSum = -(C[i] + D[j]);
        ans += upperBound(AB, cdSum) - lowerBound(AB, cdSum);
    }
}
System.out.println(ans);
```

3. `lowerBound`와 `upperBound`는 정렬된 배열에서 `target`이 처음/마지막으로 나오는 인덱스를 반환합니다.  
   두 값의 차이는 `target`의 등장 횟수이므로, 네 수의 합이 0이 되는 모든 조합의 개수를 효율적으로 셀 수 있습니다.

```java
static int lowerBound(int[] arr, int target) {
    int l = 0, r = arr.length;
    while (l < r) {
        int m = (l + r) / 2;
        if (arr[m] >= target) r = m;
        else l = m + 1;
    }
    return l;
}

static int upperBound(int[] arr, int target) {
    int l = 0, r = arr.length;
    while (l < r) {
        int m = (l + r) / 2;
        if (arr[m] > target) r = m;
        else l = m + 1;
    }
    return l;
}
```

## :black_nib: **Review**

- 4000^4 인 경우 int 범위로 불가능하므로 long을 쓴다.
- AB / CD 합으로 나누어 이분탐색한다.

## 📡 Link

https://www.acmicpc.net/problem/7453
