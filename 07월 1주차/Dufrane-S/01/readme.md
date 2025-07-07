# [백준- S5] 4659. 비밀번호 발음하기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 모음, 자음을 표기하는 배열을 하나 더 만들어서 연속을 판별
- 모음 포함 여부와, 같은 글자 연속 여부는 기존 문자에서 판별
```java
 private static boolean check(String text) {
        boolean isMoum = false;
        boolean[] seq = new boolean[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char now = text.charAt(i);

            if (moum.indexOf(now) != -1) {
                isMoum = true;

            }
            seq[i] = moum.indexOf(now) != -1;
            if (i != 0 && now == text.charAt(i - 1) && now != 'e' && now != 'o') {
                return false;
            }
            if (i >= 2 && seq[i - 2] == seq[i - 1] && seq[i - 1] == seq[i]) {
                return false;
            }
        }
        return isMoum;
    }
```

## :black_nib: **Review**
- 

## 📡**Link**
- https://www.acmicpc.net/problem/4659
