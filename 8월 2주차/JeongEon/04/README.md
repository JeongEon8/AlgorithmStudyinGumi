# \[백준 - 실버 2] 2805. 나무 자르기

## ⏰  **time**

20분

## \:pushpin: **Algorithm**

이진 탐색 (Parametric Search)

## ⏲️**Time Complexity**

\$O(N \log H\_{\max})\$

* $N$: 나무의 수
* $H_{\max}$: 가장 높은 나무 높이

## \:round\_pushpin: **Logic**

1. 나무 높이를 입력받아 벡터에 저장하고, 최댓값으로 `end` 초기화. `start=0`, `result=0`.
2. 절단기 높이 `mid = (start + end) / 2` 로 가정.
3. 모든 나무에 대해 `tree[i] > mid`이면 잘려 나오는 길이 `tree[i] - mid` 를 `total`에 누적.
4. `total < m` 이면 나무를 덜 잘랐으므로 더 **낮게** 잘라야 함 → `end = mid - 1`.
5. `total >= m` 이면 조건을 만족 → `result = mid` 저장 후 더 **높게** 잘라도 되는지 탐색 → `start = mid + 1`.
6. 탐색 종료 후 `result`가 가져갈 수 있는 최대 절단기 높이.

```cpp
int start = 0;
int end = *max_element(tree.begin(), tree.end());
int result = 0;

while (start <= end) {
    long long total = 0;
    int mid = (start + end) / 2;

    for (int h : tree) if (h > mid) total += (h - mid);

    if (total < m) end = mid - 1;     // 부족 → 더 낮게 자르기
    else {                            // 충분 → 높이 올려보기
        result = mid;
        start = mid + 1;
    }
}
cout << result;
```

## \:black\_nib: **Review**

* 전형적인 파라메트릭 서치. 합계는 `long long`으로 안 잡으면 바로 오버플로 함.
* 경계 갱신 방향만 안 헷갈리면 구현은 깔끔!

## 📡 Link

[https://www.acmicpc.net/problem/2805](https://www.acmicpc.net/problem/2805)
