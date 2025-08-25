# [백준 - S1] 17828. 문자열 화폐

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
남은 칸을 A로 모두 채울수 있다면 문자열의 가장 뒤부터 채울수있는 가장 큰 문자를 채운다.  
출력할때 reverse로 뒤집어서 출력한다.
```java
if ((x > n * 26) || n > x) {
    System.out.println("!");
} else {
    for (int i = 0; i < n; i++) {
        int tmp = x - (n - i - 1);
        if (tmp >= 26) {
            sb.append("Z");
            x -= 26;
        } else {
            char c = (char) ('A' + tmp - 1);
            sb.append(c);
            x -= tmp;
        }
    }
    System.out.println(sb.reverse());
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/17828