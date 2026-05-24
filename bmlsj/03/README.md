# [PGS - Lv2] 03\_마법의 엘리베이터

## ⏰**time**

30min

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

0으로 만드는 최소 비용 계산

1. `digit < 5`면, 현재 자리만큼 내려가는게 이득
2. `digit > 5`면, 다음 자리로 올림하는게 이득이므로, `10 - digit`만큼 더하고 `storey + 10`을 수행
   - 어짜피 `storey / 10`을 수행함으로 1의 자리는 버려도 됨.
3. `digit = 5`일 경우는 다음 자릿수 확인이 필요하다
   - 다음 자리수가 `5`이상이면 올림
   - 그렇지 않으면 내리기
4. 다음 자릿수로 이동하기 위해 `storey /= 10` 수행

```java
while(storey > 0) {
    int digit = storey % 10;

    if (digit > 5) { // 절반 이상일 경우, 올림
        answer += 10 - digit;
        storey += 10;
    } else if (digit < 5) {
        answer += digit;
    } else {
        int next = (storey / 10 ) % 10;
        answer += 5;
        if (next >= 5) {
            storey += 10;
        }
    }

    storey /= 10;
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/148653>

- <https://school.programmers.co.kr/learn/courses/30/lessons/148653>
- <https://school.programmers.co.kr/learn/courses/30/lessons/148653>
- <https://school.programmers.co.kr/learn/courses/30/lessons/148653>
