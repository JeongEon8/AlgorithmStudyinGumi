# [백준- S1] 5525. IOIOI
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(M)$

## :round_pushpin: **Logic**
- 문자 하나하나 비교하기 위해 char 배열로 만들기
- Pn은 `OI`가 n번 나오는 것 ⇒ `OI`의 개수를 세면 됨
  - 따라서 `OI`가 n번 이상 나왔고, 시작이 `I`이면 문자열이 포함된 것
```java
int ans = 0;
int[] check = new int[M]; // OI가 나온 개수를 저장하는 배열
// 처음이 OI로 시작하면 의미가 없으므로 i는 1부터 시작 
for (int i = 1; i < M - 1; i++) {
  if (chars[i] == 'O' && chars[i + 1] == 'I')
    check[i + 1] = check[i - 1] + 1;

  // OI가 N번 이상 나왔고 시작 문자가 I라면 포함된 것
  // OI가 2번 > IOIOI (길이 5) => (i + 1) - (1 + 2 * N) - 1 = i - 2 * N + 1
  if (check[i + 1] >= N && chars[i - 2 * N + 1] == 'I')
    ans++;
}
```

## :black_nib: **Review**
substring을 사용해서 쉽게 풀려고 했는데 그렇게 풀면 반틈만 맞는 문제였다. 주어지는 N, M이 크기때문에 생각을 조금 해야 하는 문제였던 것..

## 📡**Link**
- https://www.acmicpc.net/problem/5525
