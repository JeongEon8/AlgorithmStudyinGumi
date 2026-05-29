# [PGS - Lv2] 02_프로세스

## ⏰**time**

29분

## :pushpin: **Algorithm**

* Queue
* 정렬
* 시뮬레이션
* 구현

## ⏲️**Time Complexity**

$O(N \log N + K)$
`priorities` 배열을 정렬하는 데 $O(N \log N)$이 걸린다.
이후 프로세스를 큐에서 꺼내고 다시 넣는 시뮬레이션을 수행한다.

최악의 경우 여러 번 재배치가 발생할 수 있으므로, 시뮬레이션 횟수를 `K`라고 하면 전체 시간 복잡도는 $O(N \log N + K)$이다.

문제 제한에서는 `N`이 최대 100이므로 충분히 처리 가능하다.

## :round_pushpin: **Logic**

1. 각 프로세스의 우선순위와 원래 위치를 함께 저장해야 한다.

   따라서 `LinkedList<int[]>`를 큐처럼 사용하고, 배열에는 `{우선순위, 원래 인덱스}`를 저장한다.

```java
LinkedList<int[]> list = new LinkedList<>();

for (int i = 0; i < priorities.length; i++) {
    list.add(new int[] {priorities[i], i});
}
```

2. 현재 실행해야 하는 가장 높은 우선순위를 빠르게 확인하기 위해 `priorities` 배열을 오름차순 정렬한다.

```java
Arrays.sort(priorities);
```

3. `cnt`는 지금까지 실행된 프로세스 개수를 의미한다.

   오름차순 정렬된 배열에서 현재 실행되어야 할 가장 높은 우선순위는 다음 위치에 있다.

```java
priorities[priorities.length - cnt - 1]
```

4. 큐의 맨 앞 프로세스를 꺼낸다.

```java
int[] cur = list.remove();
```

5. 현재 프로세스보다 더 높은 우선순위가 대기 중이라면, 현재 프로세스는 실행하지 않고 큐의 뒤로 보낸다.

```java
if (cur[0] < priorities[priorities.length - cnt - 1]) {
    list.add(cur);
    continue;
}
```

6. 현재 프로세스가 가장 높은 우선순위라면 실행한다.

   실행된 프로세스 수를 증가시키고, 이 프로세스가 찾고자 하는 `location`의 프로세스라면 현재 실행 순서인 `cnt`를 반환한다.

```java
cnt++;

if (cur[1] == location) {
    return cnt;
}
```

7. 큐가 빌 때까지 반복하며, 목표 프로세스가 실행되는 순서를 찾는다.

```java
while (!list.isEmpty()) {
    int[] cur = list.remove();

    if (cur[0] < priorities[priorities.length - cnt - 1]) {
        list.add(cur);
        continue;
    }

    cnt++;

    if (cur[1] == location) {
        return cnt;
    }
}
```

## :black_nib: **Review**

* 프로세스의 우선순위뿐만 아니라 원래 위치도 함께 추적해야 해서 `{우선순위, 인덱스}` 형태로 큐에 저장했다.
* 매번 큐 전체에서 최대 우선순위를 찾는 대신, 정렬된 `priorities` 배열을 활용해 현재 실행해야 할 우선순위를 확인했다.
* 현재 실행된 개수 `cnt`를 기준으로 `priorities.length - cnt - 1` 위치를 참조하면 다음으로 실행될 우선순위를 알 수 있었다.
* 문제 제한이 작기 때문에 큐 시뮬레이션 방식으로 충분히 해결 가능했다.
* 다만 원본 `priorities` 배열을 정렬하면서 변경하므로, 원래 우선순위 배열이 이후에 필요하다면 복사본을 정렬하는 방식이 더 안전하다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/42587](https://school.programmers.co.kr/learn/courses/30/lessons/42587)
