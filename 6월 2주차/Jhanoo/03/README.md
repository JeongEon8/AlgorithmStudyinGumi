# [PGS - Lv2] 03_[3차] 압축

## ⏰**time**

47분

## :pushpin: **Algorithm**

* 문자열 처리
* HashMap
* LZW 압축
* 구현
* Stack

## ⏲️**Time Complexity**

$O(N^2)$
`N`은 문자열 `msg`의 길이이다.
문자열을 순차적으로 처리하면서 사전에 존재하는 가장 긴 문자열을 찾는다.
현재 코드에서는 `w = w + c`처럼 문자열을 이어 붙이는 연산이 반복되므로, 문자열 생성 비용까지 고려하면 최악의 경우 $O(N^2)$로 볼 수 있다.

문제 제한에서는 `msg`의 길이가 최대 1000이므로 충분히 처리 가능하다.

## :round_pushpin: **Logic**

1. 문제는 LZW 압축 과정을 구현하는 문제이다.

   먼저 사전에 `A`부터 `Z`까지의 알파벳을 등록한다.

   ```java
   HashMap<String, Integer> dict = new HashMap<>();
   int dictSize = 0;
   char ch = 'A';

   while(ch <= 'Z') {
       dict.put("" + ch++, ++dictSize);
   }
   ```

2. 입력 문자열을 앞에서부터 처리해야 한다.

   현재 코드는 `Stack`을 사용하기 위해 문자열을 뒤에서부터 넣어, `pop()`했을 때 원래 문자열의 앞 문자부터 나오도록 만들었다.

   ```java
   Stack<String> stack = new Stack<>();

   for (int i = 0; i < msg.length(); i++) {
       stack.push("" + msg.charAt(msg.length() - i - 1));
   }
   ```

3. 스택에서 문자를 하나 꺼내 현재 문자열 `w`로 둔다.

   `w`는 사전에 존재하는 현재까지의 문자열이다.

   ```java
   String w = stack.pop();
   Integer wIdx = dict.get(w);
   ```

4. 더 이상 확인할 문자가 없다면 현재 문자열의 색인 번호를 출력하고 종료한다.

   ```java
   if (stack.isEmpty()) {
       list.add(wIdx);
       break;
   }
   ```

5. 다음 문자 `c`를 꺼내 `w + c`가 사전에 존재하는지 확인한다.

   ```java
   String c = stack.pop();
   Integer wcIdx = dict.get(w + c);
   ```

6. `w + c`가 사전에 존재한다면, 더 긴 문자열을 만들 수 있다는 뜻이다.

   따라서 `w`를 `w + c`로 확장하고, 다음 문자를 계속 확인한다.

   ```java
   while (wcIdx != null && !stack.isEmpty()) {
       w = w + c;
       c = stack.pop();

       wcIdx = dict.get(w + c);
   }
   ```

7. 만약 `w + c`가 사전에 존재하고, 더 이상 확인할 문자가 없다면 해당 문자열의 색인 번호를 출력하고 종료한다.

   ```java
   if (wcIdx != null && stack.isEmpty()) {
       list.add(wcIdx);
       break;
   }
   ```

8. `w + c`가 사전에 없다면, 현재 사전에 존재하는 가장 긴 문자열은 `w`이다.

   따라서 `w`의 색인 번호를 출력한다.

   ```java
   wIdx = dict.get(w);
   list.add(wIdx);
   ```

9. 새 문자열 `w + c`를 사전에 추가한다.

   이후 `c`는 아직 처리되지 않은 다음 시작 문자이므로 다시 스택에 넣는다.

   ```java
   dict.put(w + c, ++dictSize);
   stack.push(c);
   ```

10. 압축 결과를 저장한 `List<Integer>`를 `int[]`로 변환해 반환한다.

```java
int[] answer = list.stream().mapToInt(i -> i).toArray();
return answer;
```

## :black_nib: **Review**

* LZW 압축의 핵심은 현재 입력에서 사전에 존재하는 가장 긴 문자열 `w`를 찾고, 그 색인 번호를 출력한 뒤 `w + c`를 새로 사전에 등록하는 것이다.
* 처음 사전에 `A`부터 `Z`까지 넣어두고, 이후 새로 발견되는 문자열을 순서대로 추가하는 방식으로 구현할 수 있었다.
* `Stack`을 사용해 문자열을 앞에서부터 처리하도록 만들었지만, 인덱스 포인터를 사용하는 방식으로도 더 간단하게 구현할 수 있다.
* 현재 코드는 `w = w + c`처럼 문자열을 반복해서 이어 붙이므로 문자열 생성 비용이 발생한다. 입력 제한이 작아 통과에는 문제가 없지만, 더 깔끔하게 작성하려면 `StringBuilder`나 인덱스 기반 탐색을 고려할 수 있다.
* LZW 문제는 조건 분기가 많아 보이지만, 결국 `가장 긴 w 찾기`, `w 출력`, `w + c 등록` 흐름만 정확히 유지하면 된다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17684
