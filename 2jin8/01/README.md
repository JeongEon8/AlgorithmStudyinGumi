# [SWEA - D2] 14510. 나무 높이
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
그리디

## :round_pushpin: **Logic**
- 최소 일수로 주기 위해 홀수날에 줘야하는 경우와 짝수날에 줘야하는 경우를 나누고, 그 균형을 맞춰야 함
- 홀수날이 더 많은지, 짝수날이 더 많은지에 따라 최소 일수를 계산하기
```java
// 1의 개수 = 홀수날 물을 줘야하는 횟수
// 2의 개수 = 짝수날 물을 줘야하는 횟수
int oneCnt = 0, twoCnt = 0;
for (int tree : trees) {
  // 최대 높이와의 차이 구하기
  int diff = maxH - tree;
  if (diff == 0) // 최대 높이면 넘어가기
    continue;

  // 1의 개수, 2의 개수 구하기
  oneCnt += diff % 2; // 1의 개수
  twoCnt += diff / 2; // 2의 개수
}

// 최소 일수를 구하기 위해 1의 개수와 2의 개수 균형 맞추기
if (oneCnt < twoCnt) { // 2일 = 1일 + 1일로 쪼갤 수 있음
  // 최소 일수가 되려면 1의 개수와 2의 개수의 차이가 1이여야 함
  while (Math.abs(oneCnt - twoCnt) > 1) {
    twoCnt--;
    oneCnt += 2;
  }
}

// 1의 개수가 더 크면
int ans = 0;
// 둘의 개수가 같다면 최소 일수는 "1의 개수 + 2의 개수"
if (oneCnt == twoCnt) { // ex) 1 2 1 2
  ans = oneCnt + twoCnt;
}
// 1의 개수가 더 크다면 최소 일수는 "1의 개수 * 2 - 1"
else if (oneCnt > twoCnt) { // ex) 1 2 1 2 1
  ans = oneCnt * 2 - 1;
}
// 2의 개수가 더 크다면 최소 일수는 "2의 개수 * 2"
else { // ex) 1 2 1 2 _ 2
  ans = twoCnt * 2;
}
```

## :black_nib: **Review**
홀수날과 짝수날에 주는 횟수의 균형을 맞추는 부분을 구현하는 것을 떠올리기 어려워서 다른 풀이를 참고했다.

## 📡**Link**
- https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do
