# [백준 - S2] 11000. 강의실 배정
 
## ⏰  **time**
90븐

## :pushpin: **Algorithm**
- 우선순위 큐

## :round_pushpin: **Logic**
- 강의 시작시간과 끝나는 시간을 담는 클래스 생성
  	- 클래스를 만들때 Comparable 사용해서 정렬기준 시작시간으로 정해준다.
- arrays.sort를 사용해서 정렬 해준다.
- 0번째를 큐에 담고 1부터 N까지 for문을 돌려준다.
- 큐에 담겨있는 첫번째 클래스의 끝나는 시간과 for문에 현재 탐색중인 클래스의 시작시간이 포함이 안되면 그냥 큐에 담고 
포함이 된다면 큐에서 poll을 사용해서 첫번째를 제거 하고 for문으로 탐색중인 클래스 큐에 담아 준다.
- 마지막으로 큐안에 사이즈를 출력한다.


```java
public static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Time o) {
            return Integer.compare(this.start, o.start);
        }
    }
```

## :black_nib: **Review**
- 처음에 강의 시간 최대만큼 배열을 만들어서 강의 시간 만큼 +1 해주려고 했는데 시간이 오래걸려서 인터넷에서 힌트를 얻었어요

## 📡**Link**
- https://www.acmicpc.net/problem/11000
