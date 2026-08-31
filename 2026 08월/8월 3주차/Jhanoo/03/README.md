# [PGS - Lv2] 03_괄호 변환

## ⏰**time**

37분

## :pushpin: **Algorithm**

- 재귀
- 문자열
- 구현
- 괄호 검사

## ⏲️**Time Complexity**

$O(N^2)$

문자열 길이를 `N`이라고 하자.

각 재귀 단계에서 현재 문자열을 `u`, `v`로 나누기 위해 `divide()`가 문자열을 순회하고, `u`가 올바른 괄호 문자열인지 확인하기 위해 `isRight()`도 순회한다.

최악의 경우 `u`의 길이가 매우 짧게 나뉘면서 재귀 호출이 여러 번 발생할 수 있다.

각 단계에서 처리하는 문자열의 길이가

```text
N, N-2, N-4, ...
```

와 같이 감소할 수 있으므로 전체 연산량은

```text
N + (N-2) + (N-4) + ...
```

가 되어 최악의 경우 $O(N^2)$이다.

## :round_pushpin: **Logic**

1. 문제의 변환 과정이 남은 문자열 `v`에 대해 동일하게 반복되므로 재귀 함수 `convert()`를 사용한다.

   ```java
   public String solution(String p) {
       return convert(p);
   }
   ```

2. 입력 문자열이 비어 있으면 더 이상 변환할 것이 없으므로 빈 문자열을 반환한다.

   ```java
   if (w.isEmpty()) {
       return "";
   }
   ```

3. 문자열 `w`를 가장 작은 균형잡힌 괄호 문자열 `u`와 나머지 문자열 `v`로 분리한다.

   ```java
   String[] divided = divide(w);
   String u = divided[0];
   String v = divided[1];
   ```

4. `divide()`에서는 `(`를 만나면 `balance`를 증가시키고, `)`를 만나면 감소시킨다.

   ```java
   if (w.charAt(i) == '(') {
       balance++;
   } else {
       balance--;
   }
   ```

5. `balance`가 처음으로 `0`이 되는 위치까지가 가장 작은 균형잡힌 괄호 문자열 `u`이다.

   ```java
   if (balance == 0) {
       return new String[] {
           w.substring(0, i + 1),
           w.substring(i + 1)
       };
   }
   ```

6. `u`가 올바른 괄호 문자열인지 검사한다.

   ```java
   if (isRight(u)) {
       return u + convert(v);
   }
   ```

   `u`가 올바른 괄호 문자열이라면 `u`는 그대로 두고, 나머지 `v`만 다시 재귀적으로 변환한다.

7. 올바른 괄호 문자열인지 확인할 때는 `balance`가 중간에 음수가 되는지 확인한다.

   ```java
   if (balance < 0) {
       return false;
   }
   ```

   `balance < 0`이라는 것은 닫는 괄호 `)`가 여는 괄호 `(`보다 먼저 많이 등장했다는 뜻이므로 올바른 괄호 문자열이 아니다.

8. `u`가 올바른 괄호 문자열이 아니라면 새로운 문자열을 만든다.

   먼저 `(`를 붙이고 `v`를 재귀적으로 변환한 결과를 붙인 뒤 `)`를 붙인다.

   ```java
   StringBuilder sb = new StringBuilder();

   sb.append("(");
   sb.append(convert(v));
   sb.append(")");
   ```

9. `u`의 첫 번째와 마지막 문자를 제거하고, 나머지 괄호의 방향을 모두 뒤집는다.

   ```java
   for (int i = 1; i < u.length() - 1; i++) {
       if (u.charAt(i) == '(') {
           sb.append(')');
       } else {
           sb.append('(');
       }
   }
   ```

10. 완성된 문자열을 반환한다.

   ```java
   return sb.toString();
   ```

## :black_nib: **Review**

- 처음에는 반복문으로 `u`, `v`를 계속 나누면서 처리하려 했지만, `v`에 대해 동일한 변환 과정이 반복된다는 점에서 재귀 구조가 더 적합하다고 판단했다.
- 문제에 제시된 변환 절차 자체가 재귀적으로 정의되어 있어 그대로 함수로 옮기면 구현이 자연스러웠다.
- 균형잡힌 괄호 문자열은 `(`와 `)`의 개수만 같으면 되지만, 올바른 괄호 문자열은 탐색 도중 닫는 괄호가 더 많아지면 안 된다는 차이를 구분해야 했다.
- `balance` 하나만 이용하면 별도로 여는 괄호와 닫는 괄호 개수를 각각 저장하지 않고도 문자열 분리와 올바른 괄호 검사를 처리할 수 있었다.
- 문자열을 가장 작은 균형잡힌 괄호 문자열 `u`로 나눈 뒤, 나머지 `v`에 동일한 함수를 다시 적용하는 것이 핵심이었다.
- 재귀 문제에서는 반복되는 작업을 찾고, 그 작업을 함수 하나의 입력과 출력으로 정의하는 것이 중요하다는 점을 다시 확인했다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/60058
