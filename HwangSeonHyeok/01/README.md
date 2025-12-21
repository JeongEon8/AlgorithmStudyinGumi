# [백준 - S4] 11656. 접미사 배열

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 문자열
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
접미사를 List에 넣고 정렬을한다.
```java
List<String> suffixList = new ArrayList<>();
for (int i = 0; i < len; i++) {
    suffixList.add(str.substring(i, len));
}
Collections.sort(suffixList);
StringBuilder sb = new StringBuilder();
for (String suffix : suffixList) {
    sb.append(suffix).append('\n');
}
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/11656