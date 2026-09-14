# [PGS - Lv2] 01_문자열 압축

## ⏰**time**

41분

## :pushpin: **Algorithm**

* 완전탐색
* 문자열
* 구현

## ⏲️**Time Complexity**

$O(N^2)$

문자열의 길이를 `N`이라고 하자.

압축 단위 `len`을 `1`부터 `N / 2`까지 모두 확인한다.

각 압축 단위마다 문자열을 `len`씩 이동하면서 전체 문자열을 한 번 순회하므로 하나의 단위에 대해 최대 $O(N)$이 걸린다.

압축 단위의 개수도 최대 $N / 2$개이므로 전체 시간 복잡도는

```text
O(N × N/2)
```

즉,

```text
O(N²)
```

이다.

## :round_pushpin: **Logic**

1. 압축하지 않았을 때의 문자열 길이를 초기 정답으로 설정한다.

   ```java
   int answer = s.length();
   ```

   문자열 길이가 `1`이면 압축 단위를 시도하는 반복문이 실행되지 않으므로 원래 문자열 길이를 그대로 반환할 수 있다.

2. 문자열을 자르는 단위를 `1`부터 `s.length() / 2`까지 모두 시도한다.

   ```java
   for (int len = 1; len <= s.length() / 2; len++) {
       ...
   }
   ```

   문자열 길이의 절반보다 큰 단위는 같은 문자열 조각이 두 번 이상 반복될 수 없으므로 확인할 필요가 없다.

3. 현재 압축 단위만큼 문자열의 첫 부분을 잘라 `prev`에 저장한다.

   ```java
   String prev = s.substring(0, len);
   int cnt = 1;
   ```

   `cnt`는 `prev`가 연속으로 몇 번 등장했는지를 저장한다.

4. 문자열의 맨 앞부터 `len` 단위로 고정해서 자른다.

   ```java
   for (int i = len; i < s.length(); i += len) {
       int end = Math.min(i + len, s.length());
       String cur = s.substring(i, end);
   }
   ```

   마지막에 `len`보다 적은 문자가 남아 있어도 `Math.min()`을 이용해 남은 부분만 잘라낸다.

5. 현재 문자열 조각 `cur`가 이전 조각 `prev`와 같으면 반복 횟수를 증가시킨다.

   ```java
   if (cur.equals(prev)) {
       cnt++;
   }
   ```

   예를 들어

   ```text
   ab | ab | ab
   ```

   라면 `cnt = 3`이 된다.

6. 현재 조각이 이전 조각과 다르다면 지금까지 반복된 `prev`를 압축 결과에 반영한다.

   ```java
   else {
       if (cnt > 1)
           tmp += String.valueOf(cnt).length();

       tmp += prev.length();

       prev = cur;
       cnt = 1;
   }
   ```

   반복 횟수가 1보다 크다면 압축 문자열 앞에 반복 횟수가 붙으므로 해당 숫자의 자릿수를 더한다.

   예를 들어

   ```text
   2ab   → 숫자 길이 1
   10ab  → 숫자 길이 2
   100ab → 숫자 길이 3
   ```

   이므로 단순히 `1`을 더하는 것이 아니라

   ```java
   String.valueOf(cnt).length()
   ```

   를 사용한다.

7. 반복 횟수가 `1`이라면 숫자를 붙이지 않는다.

   ```text
   ab  → ab
   2ab → 2ab
   ```

   따라서 다음 조건에서만 반복 횟수의 길이를 더한다.

   ```java
   if (cnt > 1)
       tmp += String.valueOf(cnt).length();
   ```

8. 반복문이 끝나면 마지막 `prev`는 아직 압축 길이에 반영되지 않았으므로 따로 처리한다.

   ```java
   if (cnt > 1)
       tmp += String.valueOf(cnt).length();

   tmp += prev.length();
   ```

   마지막 문자열 조각이 압축 단위보다 짧더라도 `prev.length()`를 사용하기 때문에 실제 남은 길이만 정확하게 더할 수 있다.

9. 현재 압축 단위로 만든 문자열 길이와 기존 최솟값을 비교한다.

   ```java
   answer = Math.min(answer, tmp);
   ```

10. 모든 압축 단위를 확인한 뒤 가장 짧은 압축 문자열의 길이를 반환한다.

```java
return answer;
```

## :black_nib: **Review**

* 처음에는 반복되는 문자열을 어느 위치에서든 찾아 압축하는 문제라고 생각했지만, 문제에서 말하는 압축 단위는 문자열의 맨 앞부터 고정된 길이로 자르는 방식이었다.
* 따라서 시작 위치를 변경할 필요 없이 압축 단위만 `1`부터 `N / 2`까지 바꿔가며 모든 경우를 확인하면 됐다.
* 현재 문자열 조각과 이전 문자열 조각을 비교하면서 동일한 조각이 연속으로 등장한 횟수를 `cnt`로 관리했다.
* 반복 횟수가 `10`, `100`처럼 두 자리 이상이 될 수 있으므로 압축 길이를 계산할 때 `String.valueOf(cnt).length()`로 숫자의 자릿수를 계산해야 했다.
* 마지막 문자열 조각은 반복문 안에서 처리되지 않을 수 있으므로 반복문이 끝난 뒤 별도로 결과에 반영해야 했다.
* 압축 단위보다 짧은 문자열이 마지막에 남을 수 있기 때문에 고정된 `len`이 아니라 `prev.length()`를 더해야 했다.
* 가능한 압축 단위를 모두 확인하는 완전탐색이지만 문자열 길이가 크지 않아 충분히 해결할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/60057
