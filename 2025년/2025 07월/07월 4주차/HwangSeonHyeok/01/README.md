# [백준 - S1] 31784. 포닉스의 문단속

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
가장 왼쪽 문자부터 A가 아닌경우 다이얼을 돌려서 A를 만들수 있으면 그만큼 돌리고 아닌 경우 그냥 넘어가는 식으로 마지막 문자에서 남은 횟수만큼 모두 돌리면된다.
```java
for (int i = 0; i < n - 1; i++) {
    int current = (int) password.charAt(i) - 'A';
    if (current == 0) {
        sb.append('A');
        continue;
    }
    int remain = 26 - current;
    if (k >= remain) {
        k -= remain;
        sb.append('A');
    } else {
        sb.append((char) ('A' + current));
    }
}
sb.append((char) ('A' + ((password.charAt(n - 1) - 'A') + k) % 26));
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/31784
