# [PGS - Lv2] 01_2개 이하로 다른 비트

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 짝수일 때
   - 마지막 0을 1로 바꿔, 정확히 1개만 다른 가장 작은 수가 될 수 있따.
2. 홀수일 때
   - 홀수는 이진수로 나타내면 마지막 비트가 1로 끝난다. 홀수에서 가장 처음으로 0이 나오는 위치를 찾아서, 가장 하위 비트에 있는 0을 1로 바꾸고 그 바로 다음에 있는 1을 0으로 바꾸면 된다.

```java
for (int i = 0; i < numbers.length; i++) {
   long num = numbers[i];
   if (num % 2 == 0) {
      answer[i] = num + 1;
   } else {
      // 앞에 0을 붙이고, 처음 나오는 0 찾기
      String bin = "0" + Long.toBinaryString(num);
      char[] chars = bin.toCharArray();

      int idx = bin.lastIndexOf("0");
      chars[idx] = '1';
      chars[idx + 1] = '0';

      answer[i] = Long.parseLong(new String(chars), 2);
   }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/77885>
