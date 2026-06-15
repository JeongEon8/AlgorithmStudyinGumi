# [PGS - Lv2] 02_[3차] n진수 게임

## ⏰**time**

25분

## :pushpin: **Algorithm**

* 문자열 처리
* 진법 변환
* 구현

## ⏲️**Time Complexity**

$O(T \times M)$
튜브가 말해야 하는 문자는 `T`개이고, 전체 게임 문자열은 최소 `T * M` 길이만큼 필요하다.
따라서 필요한 길이만큼 문자열을 생성하고, 튜브의 순서에 해당하는 문자만 뽑으므로 전체 시간 복잡도는 $O(T \times M)$이다.

## :round_pushpin: **Logic**

1. 게임에서는 `0`부터 시작해 숫자를 `n`진수로 변환한 값을 차례대로 말한다.

   예를 들어 `n = 2`라면 다음과 같은 문자열이 만들어진다.

   ```text
   0 1 10 11 100 101 110 ...
   ```

2. 튜브가 말해야 하는 문자는 총 `t`개이고, 사람 수는 `m`명이다.

   따라서 전체 문자열은 최소 `t * m` 길이 이상이면 충분하다.

   ```java
   StringBuilder sb = new StringBuilder();

   int num = 0;
   while (sb.length() < t * m) {
       sb.append(Integer.toString(num, n).toUpperCase());
       num++;
   }
   ```

3. Java의 `Integer.toString(num, n)`을 사용하면 `num`을 `n`진수 문자열로 변환할 수 있다.

   단, 10 이상의 숫자는 소문자 알파벳으로 변환되므로 `toUpperCase()`를 사용해 대문자로 변환한다.

   ```java
   Integer.toString(num, n).toUpperCase()
   ```

4. 문제에서 튜브의 순서 `p`는 1부터 시작하지만, 문자열 인덱스는 0부터 시작한다.

   따라서 튜브가 처음 말해야 하는 문자의 인덱스는 `p - 1`이다.

   이후에는 사람 수 `m`만큼 건너뛰면 된다.

   ```text
   p - 1
   p - 1 + m
   p - 1 + 2m
   p - 1 + 3m
   ...
   ```

5. 튜브가 말해야 하는 문자만 `t`개 뽑아 정답 문자열에 추가한다.

   이때 문자열을 반복해서 더하면 매번 새로운 문자열이 생성될 수 있으므로, `StringBuilder`를 사용한다.

   ```java
   StringBuilder answer = new StringBuilder();

   for (int i = p - 1; answer.length() < t; i += m) {
       answer.append(sb.charAt(i));
   }
   ```

6. 최종적으로 완성된 문자열을 반환한다.

   ```java
   return answer.toString();
   ```

## :black_nib: **Review**

* 처음에는 직접 진법 변환을 구현해야 할 것 같았지만, Java의 `Integer.toString(num, n)`을 사용하면 간단하게 처리할 수 있었다.
* 전체 게임 문자열을 필요한 길이인 `t * m` 이상만큼만 만들면 되므로, 불필요하게 많은 숫자를 변환할 필요가 없었다.
* 튜브의 순서 `p`가 1-based이고, 문자열 인덱스는 0-based이므로 시작 인덱스를 `p - 1`로 맞추는 것이 중요했다.
* 정답 문자열을 만들 때 `String`에 `+=`로 누적하는 대신 `StringBuilder`를 사용해 더 깔끔하고 효율적으로 개선할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17687
