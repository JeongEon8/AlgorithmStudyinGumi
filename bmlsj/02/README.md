# [PGS - lv2] 02. 오픈채팅방

## ⏰**time**

30분

## :pushpin: \*\*Algorithm

HashMap

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

전체 기록을 순회하며 각 ID의 최신 닉네임을 HashMap에 저장하고, 이후 메시지를 생성하는 방식으로 간단하게 해결

1. `Enter`, `Change` 명령을 순회하며 사용자 ID와 최신 닉네임을 HashMap에 저장한다.
2. 다시 전체 기록을 순회하며
   - `Enter` → "님이 들어왔습니다."
   - `Leave` → "님이 나갔습니다."
3. 출력 시에는 HashMap에 저장된 **최종 닉네임**을 사용한다.
4. 생성한 메시지 리스트를 배열로 변환하여 반환한다.

```java
HashMap<String, String> map = new HashMap<>();

for (String re : record) {
    String[] split = re.split(" ");
    String comm = split[0];

    if (comm.equals("Enter") || comm.equals("Change")) {
        map.put(split[1], split[2]);
    }
}

List<String> list = new ArrayList<>();

for (String re : record) {
    String[] split = re.split(" ");
    String comm = split[0];

    if (comm.equals("Enter")) {
        list.add(map.get(split[1]) + "님이 들어왔습니다.");
    } else if (comm.equals("Leave")) {
        list.add(map.get(split[1]) + "님이 나갔습니다.");
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42888>
