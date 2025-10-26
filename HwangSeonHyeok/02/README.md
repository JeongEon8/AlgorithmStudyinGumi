# [백준 - G4] 31091. 거짓말 

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 애드 혹
- 누적 합

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각각의 수를 누적합으로 기록한다.  
거짓말쟁이가 0명~n명까지 돌면서 불가능한 경우와 거짓말쟁이의 수가 같은 경우 추가한다.
```java
Arrays.sort(arr);
int[] sumArr = new int[n * 2 + 1];
int idx = 0;
for (int num : arr) {
    while (idx < num + n) {
        sumArr[++idx] = sumArr[idx - 1];
    }
    sumArr[idx]++;
}
while (idx < n * 2) {
    sumArr[++idx] = sumArr[idx - 1];
}
List<Integer> ansList = new ArrayList<>();
for (int i = 0; i <= n; i++) {
    int moreCnt = sumArr[2 * n] - sumArr[n + i];
    int lessCnt = sumArr[n] - sumArr[n - i];
    if (moreCnt + lessCnt == i) {
        ansList.add(i);
    }
}
```
## :black_nib: **Review**
지금보니까 정렬 안하는게 더 빨랐을것 같다.
## 📡**Link**
https://www.acmicpc.net/problem/31091