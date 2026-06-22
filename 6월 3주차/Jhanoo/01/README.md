# [PGS - Lv2] 01_택배상자

## ⏰**time**

25분

## :pushpin: **Algorithm**

- Stack
- 시뮬레이션
- 구현

## ⏲️**Time Complexity**

$O(N)$
`N`은 `order` 배열의 길이이다.
각 상자는 스택에 최대 한 번 들어가고, 최대 한 번 나오므로 전체 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. 메인 컨베이어 벨트에서는 상자가 `1`번부터 `N`번까지 순서대로 나온다.

   원하는 순서대로 바로 실을 수 없는 상자는 보조 컨베이어 벨트 역할을 하는 `Stack`에 임시로 보관한다.

   ```java
   Stack<Integer> stack = new Stack<>();
   int idx = 0;
   ```

2. `box`를 `1`부터 `order.length`까지 순서대로 확인한다.

   이는 메인 컨베이어 벨트에서 상자가 순서대로 나오는 상황을 의미한다.

   ```java
   for (int box = 1; box <= order.length; box++) {
       stack.push(box);
   }
   ```

3. 새로 들어온 상자는 일단 보조 컨베이어 벨트에 넣는다.

   이후 보조 벨트의 맨 위 상자가 현재 실어야 하는 상자인지 확인한다.

   ```java
   stack.push(box);
   ```

4. 스택의 맨 위 상자가 현재 필요한 상자 `order[idx]`와 같다면, 해당 상자를 트럭에 싣는다.

   같은 방식으로 계속 실을 수 있는 상자가 있다면 반복해서 꺼낸다.

   ```java
   while(!stack.isEmpty() && stack.peek() == order[idx]) {
       stack.pop();
       idx++;
   }
   ```

5. `idx`는 지금까지 트럭에 실은 상자의 개수이면서, 다음으로 실어야 할 상자의 위치를 의미한다.

   모든 상자를 실었다면 `idx`를 반환한다.

   ```java
   if (idx == order.length)
       return idx;
   ```

6. 더 이상 스택 맨 위에서 원하는 상자를 꺼낼 수 없다면, 다음 상자를 메인 벨트에서 가져와 다시 같은 과정을 반복한다.

7. 반복이 끝난 뒤 `idx`를 반환한다.

   ```java
   return idx;
   ```

## :black_nib: **Review**

- 처음에는 보조 벨트에 어떤 상자를 넣고 빼야 하는지 직접 조건을 나눠 처리하려 했지만, 메인 벨트에서 오는 상자를 순서대로 스택에 넣고 가능한 만큼 꺼내는 방식으로 단순화할 수 있었다.
- 스택의 맨 위 상자가 현재 필요한 상자와 같을 때만 꺼낼 수 있다는 점이 문제의 핵심이었다.
- 각 상자는 한 번 push되고 한 번 pop되므로 $O(N)$에 해결할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131704
