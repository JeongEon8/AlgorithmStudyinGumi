# [백준 - S5] 10815. 숫자 카드

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 이분탐색, 해시 맵

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
이분탐색으로 풀어봤다.
가지고 있는 숫자 리스트를 정렬하고, 찾아야 하는 숫자를 이분탐색으로 찾는다.
숫자가 있는 경우와 없는 경우가 있으니 함수로 따로 이분 탐색 로직을 구현하고,
반복문을 돌려서 이분 탐색으로 찾은 경우에는 1, 아닌 경우는 0을 출력한다.

```python
def bs(find):
    st = 0
    en = n - 1

    while st <= en:
        mid = (st + en) // 2

        if my_card[mid] == find:
            return True
        elif my_card[mid] < find:
            st = mid + 1
        else:
            en = mid - 1

    return False


for find in find_card:
    if bs(find):
        print(1, end=" ")
    else:
        print(0, end=" ")
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/10815
