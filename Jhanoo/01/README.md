# [PGS - Lv2] 01_주차 요금 계산

## ⏰**time**

45분

## :pushpin: **Algorithm**

* HashMap
* TreeMap
* 문자열 파싱
* 구현
* 정렬

## ⏲️**Time Complexity**

$O(N \log C)$
`N`은 `records`의 길이, `C`는 차량의 개수이다.
각 기록을 한 번씩 순회하면서 입차 시간과 누적 주차 시간을 계산한다.
누적 주차 시간을 저장하는 자료구조로 `TreeMap`을 사용하므로 차량번호를 삽입하거나 갱신할 때 $O(\log C)$가 걸린다.

따라서 전체 시간 복잡도는 $O(N \log C)$이다.

## :round_pushpin: **Logic**

1. 차량별 입차 시간을 저장할 `inTime`과 차량별 누적 주차 시간을 저장할 `totalTime`을 선언한다.

   `totalTime`은 차량번호 오름차순으로 결과를 반환해야 하므로 `TreeMap`을 사용한다.

   ```java
   Map<String, Integer> inTime = new HashMap<>();
   Map<String, Integer> totalTime = new TreeMap<>();
   ```

2. 각 주차 기록을 하나씩 순회하며 공백 기준으로 파싱한다.

   기록은 `시각 차량번호 IN/OUT` 형태이다.

   ```java
   String[] str = record.split(" ");
   String[] time = str[0].split(":");
   ```

3. `HH:MM` 형태의 시간을 분 단위로 변환한다.

   이후 입차 시간과 출차 시간의 차이를 계산하기 쉽게 하기 위함이다.

   ```java
   int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
   ```

4. 차량번호와 입출차 여부를 분리한다.

   ```java
   String car = str[1];
   boolean isIn = str[2].equals("IN");
   ```

5. 입차 기록이라면 해당 차량의 입차 시간을 `inTime`에 저장한다.

   ```java
   if (isIn) {
       inTime.put(car, minute);
   }
   ```

6. 출차 기록이라면 `inTime`에서 해당 차량의 입차 시간을 꺼내고, 출차 시간과의 차이를 계산한다.

   계산한 주차 시간은 `totalTime`에 누적한다.

   ```java
   else {
       int t = minute - inTime.remove(car);
       totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
   }
   ```

7. 모든 기록을 처리한 뒤에도 `inTime`에 남아 있는 차량은 출차 기록이 없는 차량이다.

   문제 조건에 따라 `23:59`에 출차한 것으로 처리한다.

   ```java
   int end = 23 * 60 + 59;

   for (String car : inTime.keySet()) {
       int t = end - inTime.get(car);
       totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
   }
   ```

8. `totalTime`은 `TreeMap`이므로 차량번호 오름차순으로 저장되어 있다.

   따라서 `totalTime.values()`를 순회하며 각 차량의 누적 주차 시간에 대한 요금을 계산한다.

   ```java
   int[] answer = new int[totalTime.size()];
   int idx = 0;

   for (int total : totalTime.values()) {
       answer[idx++] = calcFee(total, fees);
   }
   ```

9. 요금 계산은 기본 시간 이하인 경우 기본 요금을 반환한다.

   ```java
   if (total <= baseTime) 
       return baseFee;
   ```

10. 기본 시간을 초과한 경우, 초과 시간을 단위 시간으로 나눈 뒤 올림 처리한다.

정수 연산으로 올림하려면 `(extraTime + unitTime - 1) / unitTime`을 사용한다.

```java
int extraTime = total - baseTime;
int extraFee = (extraTime + unitTime - 1) / unitTime * unitFee;

return baseFee + extraFee;
```

## :black_nib: **Review**

* 처음에는 차량별로 모든 입출차 시각을 리스트에 저장한 뒤 마지막에 계산하는 방식을 생각했지만, 출차 시점에 바로 누적 시간을 계산하면 더 간단하게 처리할 수 있었다.
* 현재 입차 중인 차량은 `HashMap`으로 관리하고, 최종 정산 결과는 차량번호 오름차순이 필요하므로 `TreeMap`을 사용했다.
* 출차 기록이 없는 차량은 `23:59`에 출차한 것으로 처리해야 하는 예외 조건이 중요했다.
* 요금 계산에서 초과 시간을 단위 시간으로 나눌 때 올림 처리가 필요하므로, `Math.ceil` 대신 정수 올림 공식을 사용해 깔끔하게 계산할 수 있었다.
* 문자열 파싱, 시간 변환, 누적 시간 계산, 요금 계산을 함수와 자료구조로 나눠 생각하면 구현이 훨씬 명확해지는 문제였다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/92341
