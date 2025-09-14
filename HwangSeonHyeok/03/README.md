# [백준 - S4] 16499. 동일한 단어 그룹화하기

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 구현
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 문자열의 알파벳을 정렬하여 새로운 문자열을 만들고 이를 key로 map에 저장하여 동일한 단어를 그룹화한다.
```java
Map<String, Boolean> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    char[] cArr = in.readLine().toCharArray();
    Arrays.sort(cArr);
    StringBuilder sb = new StringBuilder();
    sb.append(cArr);
    if (!map.containsKey(sb.toString())) {
        map.put(sb.toString(), true);
    }
}
```

## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/16499