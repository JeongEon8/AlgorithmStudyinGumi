# [백준 - S5] 문서 검색


## ⏰ **time**
10분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
- 두 번쨰로 입력한 문자열의 길이 만큼 첫 번째 문자열에서 index 설정을 해서 비교하면 된다.
```python
while i<len(txt):
    if txt[i:i+n] == find:
        i += n
        cnt += 1
    else:
        i += 1
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/1543
