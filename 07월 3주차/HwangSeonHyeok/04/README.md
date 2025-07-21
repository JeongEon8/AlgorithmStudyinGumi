# [백준 - S4] 1812. 사탕

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
n이 항상 홀수이므로 홀수번째를 합을 모두 더하면 모든 사탕 합 + 첫째 학생의 사탕이고 짝수번째 합은 모두 더하면 첫번째 학생의 사탕을 제외한 사탕의 합이다.  
즉 (홀수 번째 합 - 짝수번째 합)/2를 계산하면 첫번째학생의 사탕을 구할 수 있으므로 각 학생들의 사탕을 순차적으로 구한다.
```java
int[] arr = new int[n];
int oddSum = 0;
int evenSum = 0;
for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(in.readLine());
    if (i % 2 == 0) {
        oddSum += arr[i];
    } else {
        evenSum += arr[i];
    }
}
int current = (oddSum - evenSum) / 2;
sb.append(current).append("\n");
for (int i = 0; i < n - 1; i++) {
    current = arr[i] - current;
    sb.append(current).append("\n");
}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/1812
