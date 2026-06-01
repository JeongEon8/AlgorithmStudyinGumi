# [PGS - Lv2] 02_의상

## ⏰**time**

17분

## :pushpin: **Algorithm**

* HashMap
* 조합
* 경우의 수

## ⏲️**Time Complexity**

$O(N)$
`N`은 `clothes` 배열의 길이이다. 의상 정보를 한 번 순회하며 종류별 개수를 세고, 이후 의상 종류 수만큼 한 번 더 순회하므로 전체 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. 의상은 이름과 종류로 주어진다. 이 문제에서는 의상 이름 자체보다, 각 종류별로 몇 개의 의상이 있는지가 중요하다.

   따라서 `HashMap`을 사용해 의상 종류별 개수를 저장한다.

   ```java
   HashMap<String, Integer> m = new HashMap<>();
   ```

2. `clothes` 배열을 순회하면서 `c[1]`에 해당하는 의상 종류의 개수를 1씩 증가시킨다.

   ```java
   for (String[] c : clothes) {
       m.put(c[1], m.getOrDefault(c[1], 0) + 1);
   }
   ```

3. 각 의상 종류마다 선택할 수 있는 경우의 수는 `해당 종류의 의상 개수 + 1`이다.

   여기서 `+ 1`은 해당 종류의 의상을 아무것도 선택하지 않는 경우를 의미한다.

   예를 들어 모자가 2개라면 선택지는 다음 3가지이다.

   ```text
   모자1 선택
   모자2 선택
   모자 선택 안 함
   ```

4. 모든 종류의 선택 경우의 수를 곱하면 전체 조합 수가 된다.

   ```java
   int answer = 1;

   for (int count : m.values()) {
       answer *= count + 1;
   }
   ```

5. 다만 모든 종류에서 아무것도 선택하지 않는 경우는 문제 조건상 허용되지 않는다.

   따라서 마지막에 `1`을 빼준다.

   ```java
   return answer - 1;
   ```

## :black_nib: **Review**

* 처음에는 의상 조합을 직접 만들어야 하는 문제처럼 보일 수 있지만, 실제로는 종류별 개수를 세고 경우의 수를 곱하는 조합 문제였다.
* 각 종류마다 `선택하지 않는 경우`를 포함해 `count + 1`을 곱하고, 마지막에 전체 미선택 경우만 제외하는 방식이 핵심이었다.
* `HashMap`으로 종류별 개수를 관리하니 구현이 간단해졌다.


## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/42578](https://school.programmers.co.kr/learn/courses/30/lessons/42578)
