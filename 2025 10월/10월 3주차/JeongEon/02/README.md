# [백준 - 실버 4] 3036. 링

## ⏰  **time**
15분

## :pushpin: **Algorithm**
유클리드 호제법 (최대공약수), 수학, 기약 분수 계산

## ⏲️ **Time Complexity**
- $O(N \cdot \log K)$  
  → N개의 링에 대해 각각 최대공약수(GCD)를 구함  
  (GCD는 두 수의 log 시간 안에 계산 가능)

## :round_pushpin: **Logic**
1. 첫 번째 링을 기준으로, 나머지 링들과의 회전 비율을 구해야 함
2. 두 링의 비율 = `첫 번째 링의 반지름 : 현재 링의 반지름`
3. 기약분수로 나타내기 위해 **최대공약수(GCD)**로 나누어 출력
4. GCD는 유클리드 호제법으로 계산
```cpp
int euclidean(int a, int b) {
    int r = a % b;
    if (r == 0) return b;
    return euclidean(b, r);
}
```

## :black_nib: **Review**

* 반지름을 단순히 나누기만 하면 **기약분수**가 아님
* 유클리드 호제법으로 깔끔하게 처리 가능
* 분수 출력할 때 `/`를 쓰는 형식을 기억하자

## 📡 Link
[https://www.acmicpc.net/problem/3036](https://www.acmicpc.net/problem/3036)
