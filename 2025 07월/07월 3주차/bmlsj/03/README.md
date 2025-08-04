# [백준 - G5] 1931. 회의실 배정
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$


## :round_pushpin: **Logic**
- 회의 시간이 끝나는 순으로 정렬
- 이전 회의 시간의 끝나는 시간 다음에 다음 회의 시작하는 회의만 수를 센다.


```java
Collections.sort(meetings, new Comparator<int[]>() {
	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[1] != o2[1])
			return o1[1] - o2[1]; // 끝나는 시간을 기준으로 오름차순
		else
			return o1[0] - o2[0];
		}
});

int last = 0, cnt = 0;
		
for(int[] meet: meetings) {
	if (last <= meet[0]) {
		last = meet[1];
		cnt++;
	}
}
System.out.println(cnt);
```

## :black_nib: **Review**
- 시작 시점을 기준으로 먼저 정렬했더니 이중 for문을 사용해야해서 시간초과가 발생했다.

## 📡**Link**
- https://www.acmicpc.net/problem/1931
