# [PGS - Lv2] 01\_큰 수 만들기

## ⏰**time**

30min

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

현재 숫자보다 작은 이전 숫자 제거한다.

```java
public String solution(String number, int k) {

    StringBuilder sb = new StringBuilder();

    for(char c: number.toCharArray()) {

        // 뒤의 수가 크면 제거
        while(k > 0 &&
            sb.length() > 0 &&
            sb.charAt(sb.length() - 1) < c) {

            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        sb.append(c);
    }

    sb.setLength(sb.length() - k);
    return sb.toString();
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/42883>
