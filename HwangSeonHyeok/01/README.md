# [백준 - G4] 12429. 생존자 (Small)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 브루트포스 알고리즘
- 정렬
## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
음식은 유통기한의 오름차순으로 정렬하고 총 생존시간을 오름차순으로 하는 우선순위 큐에 넣고 꺼냈을 때의 시간보다 유통기한이 긴 음식까지 idx를 올려준다.  
그 시간에 아직 먹지 않은 음식들을 먹는 경우를 하났기 다시 우선순위큐에 넣어준다.  
이런 식으로 최장 생존시간을 구하면된다.


```java
static class Time implements Comparable<Time>{
	int aliveTime;
	boolean[] eaten;

	public Time(int aliveTime, boolean[] eaten) {
		this.aliveTime = aliveTime;
		this.eaten = eaten;
	}

	@Override
	public int compareTo(Time o) {
		return this.aliveTime-o.aliveTime;
	}
}
static int solve(){
	PriorityQueue<Time> pq = new PriorityQueue();
	pq.add(new Time(0, new boolean[n]));
	int idx = 0;
	int ans = 0;
	while(!pq.isEmpty()){
		Time current = pq.poll();
		if(current.aliveTime>ans){
			ans = current.aliveTime;
		}
		while(idx<n&&foods[idx].p<current.aliveTime){
			idx++;
		}
		for(int i = idx; i<n;i++){
			if(!current.eaten[i]){
				boolean[] newEaten = new boolean[n];
				for(int j = 0; j<n;j++){
					newEaten[j] = current.eaten[j];
				}
				newEaten[i] = true;
				pq.add(new Time(current.aliveTime+foods[i].s,newEaten));
			}
		}
	}
	return ans;

}
```

## :black_nib: **Review**
그리디와 브루트포스 사이 어딘가..

## 📡**Link**

https://www.acmicpc.net/problem/12429
