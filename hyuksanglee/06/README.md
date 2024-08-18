# [백준 - G3] 17471. 게리맨더링

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 부분 집합, 트리

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

1. 2차원 배열 생성 후 인접한 정수에 1표시하기

2. 부분집합을 이용하여 만들수 있는 조합 생성하기

3. 해당 집합이 서로 연결되어 있는지 확인하고 연결되어있으면 두 선거구 차이 구하기

4. 차이값이 최솟값이랑 비교하여 갱신해주기

```java
    // 부분집합을 이용하여 선거구 나누기
	public static void subset(int count) {
		if (count == N + 1) {
			aSite = new ArrayList<>();
			bSite = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) { // A구역
					aSite.add(i);
				} else { // B구역
					bSite.add(i);
				}
			}

			makeSet();	// 트리로 묶기전에 초기화
			
			// 부분집합으로 나눈 a구역, b구역을 연결상태 확인후 연결해주기
			connect(aSite);
			connect(bSite);
			
			// 모든 구역에 대해 find 수행하여 path compression 한다. (최상단 부모 확인을 위해)
			for (int i = 0; i <= N; i++) {
				findSet(i);
			}
			
			// 연결 두개인지 확인하기 위해 정렬
			Arrays.sort(parents);
			
			// 선거구가 두개인지 확인
			int check = 1;
			for(int i = 1;i < N; i++) {
				if(parents[i] !=parents[i+1]) {
					check++;
				}
			}
			
			// 인원별 두 선거구 차이를 구해서 최솟값 비교하여 갱신해준다.
			if(check ==2) {
				int a = 0;
				int b =0;
				for(int n : aSite) {
					a+=people[n];				
					}
				for(int n : bSite) {
					b+=people[n];				
					}
				
				if(min>Math.abs(a-b)){
					min = Math.abs(a-b);
				}
			}
			
			return;
		}

		isSelected[count] = true;
		subset(count + 1);
		isSelected[count] = false;
		subset(count + 1);
	}
```

## :black_nib: **Review**

- 부분집합을 구현하는 것을 쉬웠지만 트리를 구현하는 부분이 어렵네요

## 📡**Link**

- https://www.acmicpc.net/problem/17471
