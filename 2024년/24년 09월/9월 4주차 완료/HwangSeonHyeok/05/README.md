# [백준 - s1] 27278. 영내순환버스

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 누적 합

## :round_pushpin: **Logic**

버스가 모든 구간을 도는 시간을 누적합으로 구한다. 기다리기 시작하는 시간과 사이클을 돌면서 기다리는 위치에 도착하는 시간을 탑승시간으로 계산하고 출발 지점이 도착 지점보다 작으면 그 바퀴에 더 크면 다음바퀴에 도착하는걸로 계산한다.

```java
for(int j = 0; j<m;j++) {
	split = in.readLine().split(" ");
	int from = Integer.parseInt(split[0])-1;
	int to = Integer.parseInt(split[1])-1;
	int start = Integer.parseInt(split[2]);
	int rideTime,goalTime;
	if(start%cycle>distSum[from]) {
		rideTime = (start/cycle+1)*cycle+distSum[from];
	}else {
		rideTime = (start/cycle)*cycle+distSum[from];
	}
	if(from<to) {
		goalTime = rideTime+distSum[to]-distSum[from];
	}else {
		goalTime = rideTime+cycle-distSum[from]+distSum[to];
	}
	if(goalTime>ans) {
		ans = goalTime;
	}
}

```

## :black_nib: **Review**
시작과 도착 index를 실수했었다. 출발 도착번호를 -1해줬다.  
그리고 다시보니까 탑승시간 자첸 펼요없고 도착하는게 이번 싸이클인지 다음 싸이클인지를 계산하는게 나았을듯.

## 📡**Link**

https://www.acmicpc.net/problem/27278
