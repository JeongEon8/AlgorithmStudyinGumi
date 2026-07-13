# [PGS - Lv2] 02_큰 수 만들기

## ⏰**time**

45분

## :pushpin: **Algorithm**

* Greedy
* Monotonic Stack
* StringBuilder

## ⏲️**Time Complexity**

$O(N)$
`N`은 문자열 `number`의 길이이다.

각 숫자는 스택에 한 번 추가되고, 필요하면 최대 한 번 제거된다.
따라서 전체 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. 숫자의 앞자리부터 큰 숫자가 오도록 만들어야 전체 값이 커진다.

   따라서 현재 숫자보다 작은 숫자가 스택의 뒤에 있다면 제거하는 그리디 전략을 사용한다.

2. `StringBuilder`를 스택처럼 사용한다.

   ```java
   StringBuilder stack = new StringBuilder();
   ```

3. 문자열 `number`를 왼쪽부터 순회하면서 현재 숫자를 확인한다.

   ```java
   for (int i = 0; i < number.length(); i++) {
       char current = number.charAt(i);
   }
   ```

4. 아직 제거할 수 있는 숫자가 남아 있고, 스택이 비어 있지 않다면 스택의 마지막 숫자와 현재 숫자를 비교한다.

   스택의 마지막 숫자가 현재 숫자보다 작다면, 앞쪽의 작은 숫자를 제거하는 것이 더 큰 수를 만드는 데 유리하다.

   ```java
   while (k > 0 && stack.length() > 0) {
       if (stack.charAt(stack.length() - 1) >= current)
           break;

       stack.deleteCharAt(stack.length() - 1);
       k--;
   }
   ```

5. 더 이상 제거할 숫자가 없거나, 스택의 마지막 숫자가 현재 숫자보다 크거나 같다면 현재 숫자를 스택에 추가한다.

   ```java
   stack.append(current);
   ```

6. 모든 숫자를 확인한 뒤에도 `k`가 남아 있을 수 있다.

   이는 숫자가 내림차순이거나 같은 숫자가 반복되어 앞에서 제거할 기회가 없었던 경우이다.

   이 경우 가장 작은 숫자들이 뒤쪽에 있으므로, 스택의 뒤에서 남은 개수만큼 제거한다.

   ```java
   if (k > 0) {
       stack.setLength(stack.length() - k);
   }
   ```

7. 최종적으로 스택에 남은 숫자를 문자열로 반환한다.

   ```java
   return stack.toString();
   ```

## :black_nib: **Review**

* 처음에는 삭제 여부를 별도 배열로 관리하면서 앞뒤 숫자를 비교하려 했지만, 삭제된 위치를 다시 건너뛰어야 해서 구현이 복잡해졌다.
* 현재 숫자보다 작은 앞자리 숫자를 제거하는 단조 감소 스택 방식으로 바꾸니 로직이 훨씬 단순해졌다.
* 각 숫자는 한 번 들어가고 최대 한 번 제거되므로 $O(N)$에 해결할 수 있었다.
* 숫자가 내림차순이면 반복문 안에서 제거가 발생하지 않으므로, 마지막에 남은 `k`만큼 뒤에서 제거해야 한다는 점이 중요했다.
* `StringBuilder`를 사용하면 별도의 `Stack<Character>` 없이 마지막 문자 확인, 삭제, 추가를 간단하게 처리할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
