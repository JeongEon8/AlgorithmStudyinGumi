# [백준] 2559. 수열
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
누적 합
두 포인터
슬라이딩 윈도우

## ⏲️**Time Complexity**
1492ms

## :round_pushpin: **Logic**
1. 각 조합의 합을 추출해야 함. 즉, 조합의 수만큼 순회하며 합을 도출해야 함.
2. 가능한 조합의 수 = 전체 날짜 수 - 연속 날짜 수 +1
3. 한 조합의 누적합을 구하는 식
```java
for (int j = 0; j < K; j++) {
result += arr[i + j];}
```

4. 도출된 합들 중 가장 큰 것을 maxSum 변수에 저장
```java
if (result > maxSum) {
maxSum = result;}
```

5. 이때, maxSum의 경우 음수가 될 수도 있으므로 초기화는 0이 아닌 Integer.MIN_VALUE로 설정 

## :black_nib: **Review**
-  로직은 쉬웠는데 5번을 까먹어서 틀렸다! 

## 📡**Link**
- https://www.acmicpc.net/problem/2559
