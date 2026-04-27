# [백준 - S5] 1251. 단어 나누기

## ⏰ **time**

20분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

분할 : `[0 ~ i-1] | [i ~ j-1] | [j ~ n-1]`

```java
for (int i = 1; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {

        String s1 = new StringBuilder(input.substring(0, i)).reverse().toString();
        String s2 = new StringBuilder(input.substring(i, j)).reverse().toString();
        String s3 = new StringBuilder(input.substring(j)).reverse().toString();

        String newWord = s1 + s2 + s3;

        if (ans == null || newWord.compareTo(ans) < 0) {
            ans = newWord;
        }
    }
}
```

## :black_nib: Review

## 📡**Link**

<https://www.acmicpc.net/problem/1251>
