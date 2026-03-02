# [백준 - S5] 1343. 폴리오미노

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 입력 문자열을 `.` 기준으로 분리한다.
2. `X`의 개수가 홀수라면 폴리오미노로 덮을 수 없다.
3. 최대한 `AAAA`로 채운다. => 최대 길이 `len / 4`
4. 남은 길이가 2라면 `BB`를 추가한다.

```java
for (int i = 0; i < words.length; i++) {

   int len = words[i].length();

    if (len % 2 != 0) {
        System.out.println(-1);
        return;
    }

    int aCnt = len / 4;
    int remain = len % 4;

    for (int j = 0; j < aCnt; j++) {
        result.append("AAAA");
    }

    if (remain == 2) {
        result.append("BB");
    }

    // 마지막 블록이 아니면 '.' 다시 붙이기
    if (i != words.length - 1) {
        result.append(".");
    }
}
```

## :black_nib: Review

힘드니까.. 쉬운걸로 떼우기 ㅎㅎ

## 📡**Link**

- [https://www.acmicpc.net/problem/1343](https://www.acmicpc.net/problem/1343)
