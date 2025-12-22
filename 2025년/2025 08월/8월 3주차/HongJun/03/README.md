# [백준 - S4] 국영수


## ⏰ **time**
20분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
- lamba를 사용해서 국어, 영어, 수학 순으로 정렬을 해주면된다.
- 국어, 수학은 감소하는 순서, 영어는 증가하는 순서니까 국어, 수학은 마이너스를 붙여준다.
- 그리고 마지막에 string 이름이 사전 순서니까 람다 안에 써준다.
```python
sort_li = sorted(li, key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
```


## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/10825
