# [PGS - Lv2] 02_[1차] 뉴스 클러스터링

## ⏰**time**

60분

## :pushpin: **Algorithm**

* 문자열 처리
* HashMap
* 다중집합
* 자카드 유사도

## ⏲️**Time Complexity**

$O(N + M)$
`N`은 `str1`의 길이, `M`은 `str2`의 길이이다.
각 문자열을 한 번씩 순회하며 두 글자씩 잘라 다중집합을 만들고, 이후 두 Map의 key 집합을 순회하므로 전체 시간 복잡도는 $O(N + M)$이다.

## :round_pushpin: **Logic**

1. 자카드 유사도는 두 집합의 교집합 크기를 합집합 크기로 나눈 값이다.

   하지만 이 문제에서는 같은 원소가 여러 번 등장할 수 있으므로 일반 집합이 아니라 **다중집합**으로 처리해야 한다.

   ```text
   J(A, B) = 교집합 크기 / 합집합 크기
   ```

2. 문자열을 두 글자씩 끊어 다중집합을 만든다.

   이때 대소문자는 구분하지 않으므로 먼저 대문자로 변환한다.

   ```java
   str = str.toUpperCase();
   ```

3. 문자열을 순회하면서 인접한 두 문자를 확인한다.

   ```java
   for (int i = 0; i < str.length() - 1; i++) {
       char c1 = str.charAt(i);
       char c2 = str.charAt(i + 1);
   }
   ```

4. 두 문자가 모두 알파벳인 경우에만 다중집합의 원소로 사용한다.

   숫자, 공백, 특수문자가 포함된 쌍은 제외한다.

   ```java
   if (c1 < 'A' || c1 > 'Z')
       continue;
   if (c2 < 'A' || c2 > 'Z')
       continue;
   ```

5. 유효한 두 글자 문자열을 key로 만들고, `HashMap`에 등장 횟수를 저장한다.

   ```java
   String key = "" + c1 + c2;
   map.put(key, map.getOrDefault(key, 0) + 1);
   ```

6. 두 문자열에 대해 각각 다중집합을 만든다.

   ```java
   Map<String, Integer> m1 = makeMultiSet(str1);
   Map<String, Integer> m2 = makeMultiSet(str2);
   ```

7. 교집합과 합집합을 계산하기 위해 두 Map의 key를 모두 모은다.

   ```java
   Set<String> keys = new HashSet<>();
   keys.addAll(m1.keySet());
   keys.addAll(m2.keySet());
   ```

8. 각 key에 대해 두 다중집합에서의 등장 횟수를 가져온다.

   다중집합에서 교집합은 두 개수 중 작은 값, 합집합은 두 개수 중 큰 값으로 계산한다.

   ```java
   for (String key : keys) {
       int cnt1 = m1.getOrDefault(key, 0);
       int cnt2 = m2.getOrDefault(key, 0);

       intersection += Math.min(cnt1, cnt2);
       union += Math.max(cnt1, cnt2);
   }
   ```

9. 합집합이 `0`이면 두 문자열 모두 유효한 원소가 없는 경우이다.

   이 경우 자카드 유사도는 `1`로 정의되므로 `65536`을 반환한다.

   ```java
   if (union == 0) {
       return 65536;
   }
   ```

10. 자카드 유사도에 `65536`을 곱한 뒤, 소수점 아래를 버린 정수 값을 반환한다.

정수 나눗셈을 사용하면 자연스럽게 소수점 아래가 버려진다.

```java
int answer = 65536 * intersection / union;
return answer;
```

## :black_nib: **Review**

* 처음에는 단순 집합처럼 중복을 제거하고 계산하면 될 것 같지만, 이 문제는 같은 문자열 조각이 여러 번 등장할 수 있는 **다중집합** 문제였다.
* `HashMap<String, Integer>`를 사용해 각 두 글자 문자열의 등장 횟수를 저장하니 교집합과 합집합을 쉽게 계산할 수 있었다.
* 다중집합에서 교집합은 `min(cnt1, cnt2)`, 합집합은 `max(cnt1, cnt2)`로 계산하는 점이 핵심이었다.
* 문자열을 두 글자씩 자를 때, 두 문자가 모두 알파벳인 경우만 포함해야 하므로 필터링 조건을 정확히 처리해야 했다.
* 합집합이 비어 있는 경우 자카드 유사도를 `1`로 처리해야 하는 예외 조건도 중요했다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/17677](https://school.programmers.co.kr/learn/courses/30/lessons/17677)
