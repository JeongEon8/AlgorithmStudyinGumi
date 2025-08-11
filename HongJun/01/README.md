# [백준 - S4] 1302. 베스트셀러

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 정렬, 집합과 맵

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
디렉토리를 사용해서 map에 각 단어가 나온 횟수를 저장한다.
그리고 횟수의 내림차순으로 정렬한다.
횟수의 최댓값을 저장하고 딕셔너리에서 value가 최댓값인 것의 key를 
따로 리스트에 저장하고 sort하면 사전 순으로 된다.
거기서 맨 앞에 있는 걸 출력

```python
n = int(input())
dict_book = {}
for _ in range(n):
    title = input()
    if title in dict_book:
        dict_book[title] += 1
    else:
        dict_book[title] = 1

sort_book = dict(sorted(dict_book.items(), key=lambda x: x[1], reverse=True))
_max = list(sort_book.values())[0]

result = []
for key, value in sort_book.items():
    if value == _max:
        result.append(key)

result.sort()
print(result[0])
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1302
