# [백준 - S5] 4335. 숫자 맞추기

## ⏰ **time**

20분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 스탠의 숫자는 1 ~ 10 범위안

2. "too low" → `최소값을 부른 숫자 + 1`로 올림
3. "too high" → `최대값을 부른 숫자 - 1`로 내림
4. "right on"이 나오면,

- 그 숫자가 지금까지 줄어든 범위 안에 있으면 스탠의 말들이 서로 모순되지 않음
  => `Stan may be honest`
- 범위 밖이면 `Stan is dishonest`

```java
int low = 1, high = 10;

while (true) {

    int num = Integer.parseInt(br.readLine());
    if (num == 0)
            break;
    String stan = br.readLine();

    if (stan.equals("too high")) {
            high = Math.min(high, num - 1);
    } else if (stan.equals("too low")) {
            low = Math.max(low, num + 1);
    } else if (stan.equals("right on")) {
        if (low > num || high < num) {
            System.out.println("Stan is dishonest");
        } else {
            System.out.println("Stan may be honest");
        }
        low = 1;
        high = 10;
    }
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/4335](https://www.acmicpc.net/problem/4335)
