# [백준 - S5] 4673. 셀프 넘버
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 브루트포스

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 1부터 10000까지 숫자 리스트를 돌면서 문자열로 바꾸고 셀프 넘버를 찾는다.
- 셀프 넘버들을 저장하고 정렬해서 출력한다.
```python
for i in number:
    for j in str(i):
        i += int(j)
    generated_num.add(i)
self_num = number - generated_num
for i in sorted(self_num):
    print(i)
```

## :black_nib: **Review**


## 📡 Link
https://www.acmicpc.net/problem/4673
