# [백준 - 실버3] 1904. 01타일
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
피보나치 수열, DP

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 피보나치 수열 arr[n] = arr[i - 1] + arr[i - 2];
   ```cpp
void makeBinary(string binary) {
    long long tmp;
    for (int i = 3; i <= N; i++) {
        tmp = 0;
        tmp = result[i - 1] + result[i - 2];
        result.push_back(tmp % 15746);
    }
}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/1904
