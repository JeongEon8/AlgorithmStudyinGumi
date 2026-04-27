# [백준 - S5] 7785. 회사에 있는 사람

## ⏰**time**

30분

## :pushpin: **Algorithm**

hashset

## :round_pushpin: **Logic**

1. hashset 사용하는 문자열 문제.

```
HashSet<String>set = new HashSet<>();
```

2. 사전 역순으로 정렬해야함.

- String의 정렬은 Arrays.sort가 아니다!

```
Collection.sort(list, Collections.reversOrder());
```

## 📡 Link

https://www.acmicpc.net/problem/7785
