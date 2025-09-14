# [백준 - S5] 1439. 뒤집기

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 문자열 

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
무조건 처음 나온 숫자로 통일하는게 최소이므로 연속된 0또는 1의 모든 그룹의 수+1을 2로 나눈만큼만 뒤집으면 된다.
```java
int cnt = 1;
for (int i = 1; i < s.length; i++) {
    if (s[i - 1] != s[i]) {
        cnt++;
    }
}
int ans = cnt / 2;
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/1439