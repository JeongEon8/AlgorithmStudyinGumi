# ✅ \[백준 - 골드 4] 2110. 공유기 설치

---

## ⏰ **Time**

20\~25분

---

## \:pushpin: **Algorithm**

이진 탐색 + 그리디 (Parametric Search)

---

## ⏲️ **Time Complexity**

* 정렬: $O(N \log N)$
* 이진 탐색: $O(\log (X_{\max} - X_{\min}))$
* 매 탐색마다 $O(N)$로 설치 가능성 확인
  → 전체 시간복잡도: $O(N \log D)$
  ($D$: 최대 거리 범위)

---

## \:round\_pushpin: **Problem Summary**

* 집 N개가 수직선상에 존재하고, 공유기 C개를 설치하고자 한다.
* \*\*최소 거리(Min Distance)\*\*를 가능한 크게 하여 C개의 공유기를 배치하자.
* 즉, **가장 인접한 두 공유기 사이 거리**의 최댓값을 구하는 문제.

---

## ✅ 핵심 아이디어

* 이분 탐색으로 \*\*최소 거리(mid)\*\*를 정해놓고, 그 거리 이상으로 공유기를 **C개 이상 설치할 수 있는지 판단**.
* 설치 가능하다면 → **더 넓은 거리**를 탐색 (`Left = Mid + 1`)
* 불가능하다면 → **거리를 좁힌다** (`Right = Mid - 1`)

---

## 🔎 주의할 점

* 집의 좌표는 반드시 **정렬**되어 있어야 함
* 첫 집에는 항상 공유기를 설치하고 시작

---

## 📌 핵심 코드 정리

```cpp
sort(Houses.begin(), Houses.end());

int Left = 0;
int Right = Houses.back();  // 최대 거리
int Solution = 0;

while (Left <= Right) {
    int Mid = (Left + Right) / 2;  // 거리 기준
    int Count = 1;
    int LastPos = Houses[0];

    for (int i = 1; i < N; ++i) {
        if (Houses[i] - LastPos >= Mid) {
            Count++;
            LastPos = Houses[i];
        }
    }

    if (Count >= C) {
        Solution = Mid;
        Left = Mid + 1;  // 더 넓게 가능할지도?
    } else {
        Right = Mid - 1;  // 좁혀야 함
    }
}
```

---

## 🧪 예제

```
입력
5 3
1
2
8
4
9

정렬 후 → [1, 2, 4, 8, 9]

공유기 3개 설치 → 최소 거리를 최대로: **3**
```

---

## \:black\_nib: **Review**

* 전형적인 Parametric Search 문제!
* "가능한가?" 를 판단하는 check 함수 또는 `Count` 계산이 핵심
* 공유기 개수가 **딱 C가 아닐 수 있음** → **C개 이상 설치 가능하면 OK**

---

## 📡 Link

[🔗 백준 2110번 - 공유기 설치](https://www.acmicpc.net/problem/2110)
