# [BOJ - S5] 4673. 셀프 넘버
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(10,000)$

## :round_pushpin: **Logic**
- 1부터 10,000까지의 수를 생성자로 취급한 후 만들 수 있는 수를 만들고 체크하기
- 체크되지 않은 수는 생성자가 없는 수이므로, 해당 수를 출력하면 됨
```java
for (int i = 1; i < N; i++) {
  int num = i;
  String str = String.valueOf(i);
  for (int j = 0; j < str.length(); j++) {
    num += str.charAt(j) - '0';
  }
  if (num < N)
    checkSelfNumber[num] = true; // 생성자가 있음을 표시하기
}
```

## :black_nib: **Review**
N이 생각보다 크지 않아서 하나씩 확인해도 될 것이라 생각하여 완탐으로 진행했다.

## 📡**Link**
- https://www.acmicpc.net/problem/4673
