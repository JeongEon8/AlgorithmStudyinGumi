# [백준 - G5] 12919. A와 B 2

## ⏰  **time**
60분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(2^L⋅L)$

## :round_pushpin: **Logic**
1. S에서 T를 찾는 것이 아닌, 역으로 T에서 S를 찾기
2. answer이 1이라면 이미 값을 찾은 것이므로 탈출
3. str.length()가 0이라면 더이상 진행할 수 없으므로 탈출
4. str과 시작 S가 동일하다면 answer를 1로 바꾸고 탈출
5. str 마지막이 'A'라면, 뒤에 'A'를 붙인 것이므로(1번) 제거해서 넘기기
6. str의 첫 번째가 'B'라면, 'B'를 붙여서 뒤집은 것이므로(2번) 제거하고 뒤집어서 넘기기
```java
    static void recur(String str) {
        if (answer == 1) {
            return;
        }
        if (str.length() == 0) {
            return;
        }
        if(str.equals(S)) {
            answer = 1;
            return;
        }
        if (str.charAt(str.length() - 1) == 'A') {
            recur(str.substring(0, str.length() - 1));
        }
        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
            String reverse = sb.reverse().toString();
            recur(reverse);
        }

    }
```


## :black_nib: **Review**
- 어떻게 역으로 할 생각을 하지 잉잉.. 아직 문자열 다루기도 익숙치 않은 것 같다 ... StringBuilder와 reverse()를 이용해서 뒤집기 얍..

## 📡**Link**
- https://www.acmicpc.net/problem/12919
