# [PGS - Lv2] 03_뒤에 있는 큰 수 찾기

## ⏰**time**

19분

## :pushpin: **Algorithm**

* Stack
* Monotonic Stack
* 뒤에서부터 탐색
* 구현

## ⏲️**Time Complexity**

$O(N)$
각 원소는 스택에 한 번 들어가고, 최대 한 번 제거된다.
따라서 전체 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. 각 원소의 오른쪽에 있으면서, 자신보다 큰 수 중 가장 가까운 수를 찾아야 한다.

   단순히 각 위치마다 오른쪽을 모두 탐색하면 $O(N^2)$이 되므로, 스택을 사용해 불필요한 후보를 제거한다.

2. 오른쪽에서 왼쪽으로 탐색한다.

   스택에는 현재 위치 기준으로 오른쪽에 있는 수 중, 뒤에 있는 큰 수의 후보가 될 수 있는 값들을 저장한다.

```java
Stack<Integer> stack = new Stack<>();
stack.push(numbers[n - 1]);
answer[n - 1] = -1;
```

3. 가장 오른쪽 원소는 뒤에 아무 숫자도 없으므로 정답이 `-1`이다.

```java
answer[n - 1] = -1;
```

4. 현재 숫자 `numbers[i]`보다 작거나 같은 값은 뒤에 있는 큰 수가 될 수 없다.

   따라서 스택에서 제거한다.

```java
while (true) {
    int cur = stack.pop();

    if (numbers[i] < cur) {
        answer[i] = cur;
        stack.push(cur);
        stack.push(numbers[i]);
        break;
    }

    if (stack.isEmpty()) {
        answer[i] = -1;
        stack.push(numbers[i]);
        break;
    }
}
```

5. 스택에서 꺼낸 값 `cur`가 현재 숫자보다 크다면, 그 값이 현재 숫자의 뒤에 있는 큰 수가 된다.

   이때 `cur`는 이후 다른 원소의 후보로도 사용될 수 있으므로 다시 스택에 넣는다.

```java
if (numbers[i] < cur) {
    answer[i] = cur;
    stack.push(cur);
    stack.push(numbers[i]);
    break;
}
```

6. 스택이 비었다면 현재 숫자보다 큰 수가 오른쪽에 없다는 의미이므로 `-1`을 저장한다.

```java
if (stack.isEmpty()) {
    answer[i] = -1;
    stack.push(numbers[i]);
    break;
}
```

7. 모든 원소에 대해 뒤에 있는 큰 수를 계산한 뒤 `answer`를 반환한다.

```java
return answer;
```

## :black_nib: **Review**

* 오른쪽에 있는 큰 수를 찾는 문제라 처음에는 이중 반복문을 떠올릴 수 있지만, 그렇게 풀면 최악의 경우 $O(N^2)$이 된다.
* 뒤에서부터 탐색하면서 스택에 후보 값을 저장하면, 현재 숫자보다 작거나 같은 값들을 제거하며 효율적으로 답을 구할 수 있었다.
* 각 숫자는 스택에 한 번 들어가고 최대 한 번 빠지므로 $O(N)$에 해결할 수 있다.
* 현재 코드는 `while (true)` 안에서 `pop()`을 먼저 수행하기 때문에 흐름이 조금 복잡하다. 아래처럼 `peek()`를 사용하면 더 안전하고 직관적으로 작성할 수 있다.

```java
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return answer;
    }
}
```

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/154539](https://school.programmers.co.kr/learn/courses/30/lessons/154539)
