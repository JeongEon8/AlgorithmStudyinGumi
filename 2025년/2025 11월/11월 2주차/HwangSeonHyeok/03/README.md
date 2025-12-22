# [백준 - S5] 32979. 아파트

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 구현


## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
현제 바닥인 손의 index를 전체 손 숫자(2*n)으로 나머지 연산하여 구한다.
```java
int idx = 0;
int handCnt = 2 * n;
st = new StringTokenizer(in.readLine());
StringBuilder sb = new StringBuilder();
for (int i = 0; i < t; i++) {
    int num = Integer.parseInt(st.nextToken());
    idx = (idx + num - 1) % handCnt;
    sb.append(hands[idx]).append(' ');
}
```  


## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/32979