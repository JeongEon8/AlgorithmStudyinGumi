# [백준 - S2] 11501. 주식

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
각각 미래에 팔 수 있는 가장 비싼값에 팔면된다.  
배열의 뒤에서 부터 그때까지의 가장 큰 값들에 판다는 가정으로 차익만큼 결과에 더하면 된다.
```java
int day = Integer.parseInt(in.readLine());
int[] prices = new int[day];
StringTokenizer st = new StringTokenizer(in.readLine());
for (int i = 0; i < day; i++) {
    prices[i] = Integer.parseInt(st.nextToken());
}
long benifit = 0;
int max = 0;
for (int i = day - 1; i >= 0; i--) {
    max = Math.max(max, prices[i]);
    benifit += max - prices[i];
}
sb.append(benifit).append('\n');
```
## :black_nib: **Review**
주식왕 홍준

## 📡**Link**
https://www.acmicpc.net/problem/11501