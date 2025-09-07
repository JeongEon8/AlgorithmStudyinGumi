# [백준 - G5] 1931. 회의실 배정

## ⏰  **time**
90분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 시작시간과 끝나는 시간을 담고 정렬기준 생성
2. 끝나는 게 더 빠를 수록 더 많은 회의실을 배정할 수 있고, 같을 경우에는 먼저 시작한 걸 정렬해야 [1,2] [2,2] 경우를 대비할 수 있음
```java
    static class Room implements Comparable<Room> {
        int st;
        int et;

        public Room(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Room room) {
            if(this.et < room.et) return -1;
            else if(this.et == room.et && this.st < room.st) return -1;
            else return 1;
        }
    }
```
2. 세워둔 기준대로 리스트 정렬
3. 마지막 정렬시간보다 예약 시작시간이 뒤라면 lastReserveEt를 room의 예약 종료시간으로 업데이트, answer 1 증가
```java
        Collections.sort(list);
        int lastReserveEt = -1;

        for (int i = 0; i < N; i++) {
            Room room = list.get(i);
            if(room.st >= lastReserveEt) {
                // 예약가능
                answer++;
                lastReserveEt = room.et;
            }
        }
```


## :black_nib: **Review**
- 처음에는 짧은 순으로 했다가 2퍼의 저주에서 풀려나지 못했다가.. 생각자체가 글러먹었다는 걸 나중에 알아부림.. 어렵다 그리디의 세계

## 📡**Link**
- https://www.acmicpc.net/problem/1931
