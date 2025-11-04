# [백준 - G5] 1911. 흙길 보수하기

## ⏰  **time**
60분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. 웅덩이 시작점이 `endPos` 보다 크면 새로 덮기
   - `endPos` : 현재 널빤지를 덮은 마지막 위치
2. 이미 일부 덮힌 구간이면, `start`를 `max(start, endPos)`로 조정
3. 덮어야 할 구간의 길이를 계산하고 필요한 널빤지 수를 구함 


```java
Arrays.sort(pools, (a, b) -> a[0] - b[0]);
int endPos = 0;
int ans = 0;
		
for(int[] p: pools) {
	int start = p[0];
	int end = p[1];
			
	// 이미 덮인 구간
	if (start < endPos) start = endPos;
		
	int len = end - start;
	int count = (len + L - 1) / L;
	ans += count;
		
	endPos = start + count * L;
	
}

System.out.println(ans);
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/1911
