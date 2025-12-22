# [백준 - S5] 28064. 이민희진

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 문자열
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**
이름들을 비교하면서 substring으로 각각의 접두사와 접미사가 같을 수 있는지 확인한다.
```java
int ans = 0;
for (int i = 0; i < n; i++) {
    String a = names[i];
    for (int j = i + 1; j < n; j++) {
        String b = names[j];
        int shortLen = Math.min(a.length(), b.length());
        for (int k = 1; k <= shortLen; k++) {
            if (a.substring(a.length() - k).equals(b.substring(0, k))) {
                ans++;
                break;
            }
            if (b.substring(b.length() - k).equals(a.substring(0, k))) {
                ans++;
                break;
            }
        }
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/28064