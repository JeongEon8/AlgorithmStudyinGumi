# [백준 - S5] 1543. 문서 검색

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 문자열
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
indexOf로 단어의 인덱스를 찾은 경우 카운트를 더해주고 그 단어가 끝난 뒤 인덱스에서 다시 찾는다.
```java
int ans = 0;
int idx = 0;
while (idx <= docs.length() - word.length()) {
    int wordIdx = docs.indexOf(word, idx);
    if (wordIdx != -1) {
        ans++;
        idx = wordIdx + word.length();
    } else {
        break;
    }
}
```  
## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/1543