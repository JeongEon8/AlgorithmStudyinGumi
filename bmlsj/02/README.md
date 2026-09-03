# [PGS - LV3] 02\_ 가장 긴 펠린드롬

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 홀수 길이: i 인덱스 하나를 중앙으로 두고 양옆(`left`, `right`)으로 확장

2. 짝수 길이: i와 i+1 인덱스를 중앙 두 문자로 두고 양옆으로 확장

- `while`문을 통해 대칭이 깨질 때까지 확장한 후, 찾아낸 팰린드롬의 길이를 계산하여 `maxLen`을 최댓값으로 갱신
-

```java

for(int i = 0; i < n; i++) {
    maxLen = Math.max(maxLen, expand(s, i, i));
    maxLen = Math.max(maxLen, expand(s, i, i + 1));
}

private int expand(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }

    return right - left - 1;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12904>
