# [PGS - Lv2] 03_124 나라의 숫자

## ⏰**time**

30min

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 3진법과 유사하지만, 0이 존재 하지 않고 `1, 2, 4`만 사용한다.
- 3으로 나눈 나머지를 이용해 숫자를 변환하고 나머지가 0이면 4로 처리한 후 몫에서 1을 빼준다.
  ex) 4
  - 4 / 3 = 1...1
  - 1 / 3 = 0...1
    => 11

```java
public String solution(int n) {

    String answer = "";
    String[] numbers = {"4", "1", "2"};

    while(n > 0) {
        int re = n % 3;
        answer = numbers[re] + answer;

        n = (int)Math.floor((n - 1) / 3);
    }
    return answer;
}
```

## :black_nib: **Review**

- 나머지가 0일 때 4를 활용하기 위해, numbers의 순서를 4, 1, 2로 해야한다.

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/12899>
