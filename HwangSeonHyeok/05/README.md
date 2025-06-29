# [백준 - S5] 31229. 또 수열 문제야

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 애드 혹
- 해 구성하기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
모든 수가 홀수이면  
$A_{i}+A_{j}$는 짝수이고  
$A_{i}\times A_{j}$는 항상 홀수이므로 조건에 부합하는 수열이다. 
```java
List<Integer> sequence = new ArrayList<>();
for (int i = 1; i <= n; i++) {
    sequence.add(i * 2 - 1);
}
for (int num : sequence) {
    sb.append(num).append(" ");
}
```  
## :black_nib: **Review**
조건에 맞는 규칙을 찾아서 풀었는데 이렇게 푸는게 맞나..?  
다른 규칙도 많이 있을거 같다.

## 📡**Link**
https://www.acmicpc.net/problem/31229
