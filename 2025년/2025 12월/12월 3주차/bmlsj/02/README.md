# [백준 - Lv2] 튜플

## ⏰  **time**

40분

## ⏲️**Time Complexity**

$O(N \log N)$

## :round_pushpin: **Logic**

- `{`를 만나면 새로운 리스트 생성
- `}`를 만나면 마지막 숫자를 처리 후 리스트에 추가
- 숫자가 아닌 문자를 만났을 때, 누적된 숫자가 있으면 리스트에 추가

```java
for (char c : s.toCharArray()) {
    if (c == '{') {
        arr = new ArrayList<>();
    } else if (c == '}') {
        if (num.length() > 0) {
            arr.add(Integer.parseInt(num.toString()));
            num.setLength(0);
        }
        list.add(arr);
    } else if (Character.isDigit(c)) {
        num.append(c);
    } else {
        if (num.length() > 0) {
            arr.add(Integer.parseInt(num.toString()));
            num.setLength(0);
        }
    }
}
```

## :black_nib: Review

의존성 방향 주의 => a가 b를 의존 (b -> a)

## 📡**Link**

- <https://school.programmers.co.kr/learn/courses/30/lessons/64065>
