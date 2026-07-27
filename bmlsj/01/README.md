# [PGS - Lv2] 01\_주차 요금 계산

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. IN이면 시간을 분으로 계산해 map에 추가
2. OUT이면 출차 시간에서 map에 들어있는 입차 시간만큼 빼서, 누적 주차 시간인 totalTimeMap에 추가한다.
3. 만약 map에 아직 남아있다면, 출차기록이 없는 차이므로 23:59분에 출차로 계산한다.
4. 차량번호가 작은 순으로 출력해야하기 때문에, List에 key 값을 넣어 정렬후 answer에 넣는다.

```java
HashMap<Integer, Integer> map = new HashMap<>();
Map<Integer, Integer> totalTimeMap = new HashMap<>();

for(String record : records) {
    String[] split = record.split(" ");
    int hour = Integer.parseInt(split[0].split(":")[0]);
    int min = Integer.parseInt(split[0].split(":")[1]);
    int time = hour * 60 + min;

    int num = Integer.parseInt(split[1]);
    String type = split[2];

    if (type.equals("IN")) {
        map.put(num, time);
    } else { // OUT
        int parkTime = time - map.remove(num);
        totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkTime);
    }
}
```

```java
int lastTime = 23* 60 + 59;
for(int num: map.keySet()) {
    int parkTime = lastTime - map.get(num);
    totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkTime);
}
```

```java
List<Integer> keys = new ArrayList<>(totalTimeMap.keySet());
Collections.sort(keys);

int[] answer = new int[keys.size()];
for(int i = 0; i < keys.size(); i++) {
    int num = keys.get(i);
    int time = totalTimeMap.get(num);

    if (time <= dtTime) {
        answer[i] = dtFee;
    } else {
        // 올림
        int exFee = (int) Math.ceil((double) (time - dtTime) / unitTime) * unitFee;
        answer[i] = dtFee + exFee;
    }
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/92341>
