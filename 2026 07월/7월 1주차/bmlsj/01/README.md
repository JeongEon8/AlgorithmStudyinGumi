# [PGS - lv2] 01. H-Index

## ⏰**time**

30분

## :pushpin: \*\*Algorithm

그리디

## ⏲️**Time Complexity**

$O(N\logN)$

## :round_pushpin: **Logic**

1. 오름차순 정렬을 해두었기 때문에 `i`번째 뒤에 있는 논문들은 무조건 `citations[i]`번 이상 인용되었다고 볼 수 있다.
2. `citations[i] >= remains`를 만족하는 순간, 그 뒤의 `remains`편은 모두 `remains`번 이상 인용된 것이므로 정답이다.

```python
def solution(citations):
    citations = sorted(citations)
    ans = 0

    for i in range(len(citations)):
        remains = len(citations) - i
        if citations[i] >= remains:
            ans = remains
            break

    return ans
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42747>
