# [백준 - S5] 01\_단어 정렬\_1181

## ⏰**time**

30분

## :pushpin: **Algorithm**

문자열 정렬

## :round_pushpin: **Logic**

1. Comparator 메서드

- Comparator : a,b 비교할건데 뭐가 먼저 와야하냐?
- a - b < 0 : 음수 -> a가 먼저옴
    - a가 작으니까 음수 겠지? 작은거 먼저 와야함
- a -b > 0 : 양수 -> b가 먼저옴
    - a가 크니까 양수겠지? 작은거(b) 먼저 와야함
- a - b = 0 : 두 개 같음.

```
Collectors.sort(list, (a,b)-> a-b);
```

## 📡 Link

https://www.acmicpc.net/problem/1181
