# [백준 - 실버 4] 10816. 숫자 카드 2

## ⏰**time**

30분

## :pushpin: **Algorithm**

hashmap

## :round_pushpin: **Logic**

1. 갖고 있는 숫자 카드를 hashmap에 담는데, key는 숫자 카드, value는 그 카드를 몇개 갖고 있는지를 담는다.

```
HashMap<String, Integer> map = new HashMap<>();
```

4. 주요 메서드

```
map.containsKey();
map.getOrDefault(); -> key의 value 값이 없으면 기본값을 반환함
```

## 📡 Link

https://www.acmicpc.net/problem/10816
