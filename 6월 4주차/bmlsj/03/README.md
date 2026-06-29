# [PGS - lv4] 03. 호텔 방 배정

## ⏰**time**

## :pushpin: \*\*Algorithm

유니온 파인드

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

다음 빈방 후보인 부모를 타고타고 계속 올라가는 방식.

ex) 예시 4번째에서 1번 방을 재요청 시, key 1의 값은 2이므로 2를 배정해준다. 그리고 key 2에 3을 넣어줌

- 방 개수($k$)가 최대 $10^{12}$이므로 배열 대신 HashMap을 사용하여 배정된 방만 관리
- `Value의 의미 = 다음 빈 방 후보`
  - parent Map의 Key는 현재 방 번호, Value는 해당 방을 선택했을 때 다음에 탐색해야 할 빈 방 번호를 가리킨다.
- 요청한 방이 이미 배정되어 있다면, 빈 방을 찾을 때까지 재귀적으로 부모 노드(`parent.get(room)`)를 추적한다.
- 빈 방(`next`)을 찾아 배정하는 순간, 거쳐온 모든 방들의 부모를 `next + 1`로 한 번에 갱신한다.

```java
static long findEmptyRoom(long room) {

    // 1. 해당 번호가 map에 없다면 빈방
    if (!parent.containsKey(room)) {
        // 이 방의 다음 빈방 후보는 다음번호(room + 1)
        parent.put(room, room + 1);
        return room;
    }

    // 이미 배정된 방일 경우, map에 저장된 부모(빈방 후보)를 찾음.
    long next = findEmptyRoom(parent.get(room));

    parent.put(room, next + 1);
    return next;
}
```

## :black_nib: **Review**

사실 아이디어 너무 생각안나서 카카오 블로그 참고함 Yeah~
유니온 파인드만 알면 코드 길이가 짧아진다.
TreeSet으로도 가능하긴한데, $10^{12}$의 크기라 효율적으로 잘 구현해야함.

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/64063>
