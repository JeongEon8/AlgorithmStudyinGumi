# [백준 - 실버 5] 2941. 크로아티아 알파벳
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 단어 처음부터 끝까지 탐색할 때까지 반복
2. 범위 오류를 막기 위해서 idx+2와 idx+3보다 초기단어의 길이가 크거나 같은지 확인하고 값 할당
3. 크로아티아 알파벳에 해당하는 경우, word에서 check1이나 check2를 제거하고 인덱스를 조정하고, 해당하지 않는 경우 idx만 1 증가
```java
                word = word.replaceFirst(check1, "");
                idx += 2;
                answer += 1;
```
4. 단어 처음부터 끝까지 탐색이 끝난 경우, 남은 word의 길이만큼 answer에 더하여 반환

## :black_nib: **Review**
- 실버 5 최고인데.. 쓸데없는 데서 은근 오래 걸려부렸다.. 그냥 다 replace하면 될 줄 알았는데 안된다잉

## 📡 Link
https://www.acmicpc.net/problem/2941
