# [백준 - G4] 2179. 비슷한 단어
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O((N² * L)$

## :round_pushpin: **Logic**
1. 모든 단어들 비교
2. 같은 접두어 개수가 similar보다 클 경우, idx 두 개와 similar 값 업데이트
```java
                if (tmpCnt > similar) {
                    similar = tmpCnt;
                    wordIdx = i;
                    wordNextIdx = j;
                }
```

## :black_nib: **Review**
문자열 길이가 길어지고 개수가 많아지면 시간복잡도 터질 거 같긴하지만....

## 📡**Link**
- https://www.acmicpc.net/problem/2179
