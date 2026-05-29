# [PGS - Lv2] 01_[1차] 캐시

## ⏰**time**

24분

## :pushpin: **Algorithm**

- LRU Cache
- LinkedList
- 문자열 처리
- 구현

## ⏲️**Time Complexity**

$O(N \times C)$  
`N`은 `cities`의 길이, `C`는 `cacheSize`이다.  
각 도시마다 캐시 내부에서 `contains`, `remove` 연산을 수행할 수 있고, `LinkedList`에서는 해당 연산이 최대 $O(C)$까지 걸리므로 전체 시간 복잡도는 $O(N \times C)$이다.

## :round_pushpin: **Logic**

1. 캐시는 가장 오래 사용되지 않은 데이터를 제거하는 LRU 방식으로 동작해야 한다.

   따라서 캐시의 앞쪽에는 오래전에 사용된 도시를, 뒤쪽에는 최근에 사용된 도시를 저장하도록 `LinkedList`를 사용한다.

   ```java
   LinkedList<String> cache = new LinkedList<>();
   ```

2. `cacheSize`가 `0`이면 어떤 도시도 캐시에 저장할 수 없다.

   따라서 모든 요청이 cache miss가 되므로, 도시 개수에 `5`를 곱한 값을 바로 반환한다.

   ```java
   if (cacheSize == 0)
       return cities.length * 5;
   ```

3. 도시 이름은 대소문자를 구분하지 않으므로, 비교하기 전에 모두 대문자로 변환한다.

   ```java
   String city = cities[i].toUpperCase();
   ```

4. 현재 도시가 캐시에 이미 존재하면 cache hit이다.

   이 경우 실행 시간은 `1` 증가한다.  
   또한 해당 도시는 최근에 사용된 도시가 되었으므로, 기존 위치에서 제거한 뒤 캐시의 뒤쪽에 다시 추가한다.

   ```java
   if (cache.contains(city)) {
       cache.remove(city);
       cache.add(city);
       answer++;
   }
   ```

5. 현재 도시가 캐시에 존재하지 않으면 cache miss이다.

   이 경우 실행 시간은 `5` 증가한다.

   캐시가 이미 가득 찬 상태라면, 가장 오래전에 사용된 도시인 맨 앞 원소를 제거한다.

   ```java
   else {
       if (cache.size() == cacheSize) {
           cache.remove();
       }
       cache.add(city);
       answer += 5;
   }
   ```

6. 모든 도시 요청을 처리한 뒤 누적 실행 시간 `answer`를 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

- LRU 캐시의 핵심은 cache hit가 발생했을 때 해당 데이터를 가장 최근에 사용한 상태로 갱신하는 것이다.
- `LinkedList`를 사용하면 가장 오래된 데이터를 앞에서 제거하고, 최근 사용 데이터를 뒤에 추가하는 흐름을 직관적으로 구현할 수 있었다.
- 도시 이름은 대소문자를 구분하지 않으므로, `toUpperCase()` 또는 `toLowerCase()`로 통일해서 비교해야 했다.
- 현재 풀이도 제한 내에서는 충분하지만, `LinkedList`의 `contains`, `remove`가 선형 탐색이기 때문에 더 일반적인 LRU 구현에서는 `LinkedHashMap`을 사용하면 더 효율적으로 처리할 수 있다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17680
