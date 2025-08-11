# \[백준 - 실버 2] 1654. 랜선 자르기

## ⏰  **time**

미측정

## \:pushpin: **Algorithm**

이진 탐색 (Parametric Search)

## ⏲️**Time Complexity**

\$O(K \log L\_{\max})\$

* $K$: 가지고 있는 랜선 개수
* $L_{\max}$: 입력 중 가장 긴 랜선 길이

## \:round\_pushpin: **Logic**

1. 입력을 받으면서 가장 긴 랜선 길이 $L_{\max}$를 구함.
2. 자를 길이의 탐색 구간을 $[1,\,L_{\max}]$로 두고 이분 탐색을 시작.
3. 중간값 $mid = \lfloor (lower + upper)/2 \rfloor$ 를 “자를 길이”로 가정하고,
   모든 랜선에 대해 `LAN[i] / mid` 를 합쳐 만들 수 있는 총 개수 `num`을 계산.
4. `num < N`이라면 길이를 너무 길게 잡은 것이므로 `upper = mid - 1`.
   반대로 `num >= N`이라면 더 길게 자를 수 있는지 탐색하기 위해 `answer = mid` 저장 후 `lower = mid + 1`.
5. 구간이 엇갈리면 종료, 저장해 둔 `answer`가 만들 수 있는 최대 길이.

### 핵심 코드 스니펫

```cpp
long long lower = 1, upper = maxLen, answer = 0;

while (lower <= upper) {
    long long mid = (lower + upper) / 2; // 자를 길이
    long long cnt = 0;

    for (int i = 0; i < K; i++) cnt += LAN[i] / mid;

    if (cnt < N) {            // 개수가 부족 → 더 짧게 잘라야 함
        upper = mid - 1;
    } else {                  // 충분히 나옴 → 더 길게 시도
        answer = mid;
        lower = mid + 1;
    }
}
```

### 주의 포인트

* `lower`를 0이 아닌 **1**로 시작해야 `mid`가 0이 되는 경우(분모 0) 방지.
* 합계와 경계값 계산은 **long long**으로 처리해 오버플로를 예방.
* 조건을 만족할 때마다 `answer`에 기록하고 “더 큰 길이”를 탐색해야 최대 길이를 찾을 수 있음.

## \:black\_nib: **Review**

* 경계값만 틀려도 끝없이 루프 돌거나 정답이 1 작아지는 실수가 남. `lower/upper` 업데이트 방향을 손으로 몇 케이스 검증하니 안정감 상승!

## 📡 Link

[https://www.acmicpc.net/problem/1654](https://www.acmicpc.net/problem/1654)
