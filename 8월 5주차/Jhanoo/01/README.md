# [PGS - Lv2] 01_[카카오 인턴] 수식 최대화

## ⏰**time**

46분

## :pushpin: **Algorithm**

* 완전탐색
* 문자열 파싱
* 순열
* 구현

## ⏲️**Time Complexity**

$O(N^2)$

`N`을 수식에 포함된 숫자와 연산자의 개수라고 하자.

연산자 우선순위는 `+`, `-`, `*` 세 종류이므로 가능한 경우의 수는

```text
3! = 6
```

가지뿐이다.

각 우선순위마다 숫자와 연산자 리스트를 순회하면서 연산을 수행한다.

이때 다음과 같이 `ArrayList`의 원소를 중간에서 삭제한다.

```java
numList.remove(i + 1);
opList.remove(i);
```

`ArrayList.remove(index)`는 뒤쪽 원소를 앞으로 이동시켜야 하므로 최악의 경우 $O(N)$이 걸린다.

연산자를 최대 $O(N)$번 제거하므로 하나의 우선순위를 처리하는 데 최악의 경우 $O(N^2)$이 걸린다.

우선순위 경우의 수 `6`은 상수이므로 전체 시간 복잡도는

```text
O(6 × N²) = O(N²)
```

이다.

## :round_pushpin: **Logic**

1. 수식에서 연산자와 숫자를 각각 분리한다.

   먼저 문자열을 순회하면서 `+`, `-`, `*`를 별도의 리스트에 저장한다.

   ```java
   List<Character> ops = new ArrayList<>();

   for (char c : expression.toCharArray()) {
       if (c == '+' || c == '-' || c == '*') {
           ops.add(c);
       }
   }
   ```

2. 정규식을 이용해 연산자를 기준으로 문자열을 분리하여 숫자만 추출한다.

   ```java
   String[] nums = expression.split("[+\\-*]");
   ```

   분리한 숫자는 계산 과정에서 `int` 범위를 넘어갈 수 있으므로 `long`으로 저장한다.

   ```java
   List<Long> numbers = new ArrayList<>();

   for (String num : nums) {
       numbers.add(Long.parseLong(num));
   }
   ```

3. `+`, `-`, `*` 세 연산자의 우선순위는 총 `3! = 6`가지이다.

   경우의 수가 매우 적으므로 모든 우선순위를 직접 만들어 완전탐색한다.

   ```java
   char[][] priorities = {
       {'+', '-', '*'},
       {'+', '*', '-'},
       {'-', '+', '*'},
       {'-', '*', '+'},
       {'*', '+', '-'},
       {'*', '-', '+'}
   };
   ```

4. 각 우선순위마다 원본 숫자와 연산자 리스트를 복사한다.

   ```java
   List<Long> numList = new ArrayList<>(numbers);
   List<Character> opList = new ArrayList<>(ops);
   ```

   계산 과정에서 리스트의 원소를 제거하기 때문에 원본 리스트를 그대로 사용하면 다음 우선순위 계산에 영향을 준다.

5. 현재 우선순위에서 가장 높은 연산자부터 순서대로 처리한다.

   ```java
   for (char op : priority) {
       ...
   }
   ```

6. 연산자 리스트를 탐색하면서 현재 처리할 연산자와 같은 연산자를 찾는다.

   ```java
   if (opList.get(i) == op) {
       ...
   }
   ```

   연산자 `opList[i]`는 숫자 리스트의

   ```text
   numList[i] op numList[i + 1]
   ```

   을 의미한다.

7. 두 숫자를 계산한 결과를 왼쪽 숫자 위치에 저장한다.

   ```java
   long result = calc(
       numList.get(i),
       numList.get(i + 1),
       op
   );

   numList.set(i, result);
   ```

8. 계산에 사용된 오른쪽 숫자와 연산자를 제거한다.

   ```java
   numList.remove(i + 1);
   opList.remove(i--);
   ```

   예를 들어

   ```text
   2 * 3 * 4
   ```

   에서 첫 번째 `*`를 계산하면

   ```text
   6 * 4
   ```

   가 된다.

   따라서 연산자를 삭제한 뒤에는 다음 인덱스로 넘어가면 안 되고 현재 위치를 다시 확인해야 한다.

   `for`문의 `i++`와 상쇄시키기 위해 `i--`를 사용한다.

9. 하나의 우선순위를 모두 계산하면 숫자 리스트에는 최종 결과 하나만 남는다.

   ```java
   return Math.abs(numList.get(0));
   ```

   문제에서는 결과의 절댓값을 기준으로 가장 큰 값을 요구하므로 `Math.abs()`를 사용한다.

10. 6가지 우선순위를 모두 계산하면서 가장 큰 절댓값을 저장한다.

```java
long answer = 0;

for (char[] priority : priorities) {
    long cur = getAbs(numbers, ops, priority);
    answer = Math.max(answer, cur);
}
```

11. 모든 우선순위를 확인한 뒤 최댓값을 반환한다.

```java
return answer;
```

## :black_nib: **Review**

* 처음부터 연산자 우선순위를 직접 적용하기보다 숫자와 연산자를 각각 리스트로 분리해서 처리했다.
* 연산자가 `+`, `-`, `*` 세 종류뿐이므로 우선순위는 `3! = 6`가지밖에 없어 모든 경우를 직접 확인하는 완전탐색이 가능했다.
* 각 우선순위마다 숫자와 연산자 리스트를 복사해 원본 데이터가 변경되지 않도록 했다.
* 연산을 수행하면 숫자와 연산자 리스트의 크기가 줄어들기 때문에 삭제 이후 인덱스 처리가 중요했다.
* `opList.remove(i--)`를 사용하여 삭제 후 같은 인덱스를 다시 검사하도록 했다.
* 중간 계산 결과가 커질 수 있으므로 숫자와 반환값을 `long`으로 처리해야 했다.
* 가능한 우선순위는 6개뿐이지만 `ArrayList` 중간 삭제가 $O(N)$이므로 전체 시간 복잡도는 $O(N^2)$이다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/67257
