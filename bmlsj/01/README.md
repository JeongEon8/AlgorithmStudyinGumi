# [백준 - S5] 8979. 올림픽
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**

1. 메달 수 기준으로 내림차순 정렬
2. 정렬된 순서대로 등수를 계산
  - 이전 국가와 메달 수가 같으면 같은 등수
  - 다르면 현재 index에서 +1
3. K번째 국가의 등수를 출력


```java
// 정렬
Arrays.sort(country, (o1, o2) -> {
    if (o1[1] != o2[1]) return o2[1] - o1[1]; // 금
    if (o1[2] != o2[2]) return o2[2] - o1[2]; // 은
    return o2[3] - o1[3];                     // 동
});
		
	
int rank = 1;
for(int i = 0; i < N; i++) {
			
	if (i > 0) {
		if (country[i][1] == country[i - 1][1] &&
				country[i][2] == country[i-1][2] &&
				country[i][3] == country[i-1][3] ) {
			// 이전 국가와 메달 수가 같을 때
		} else {
			rank = i + 1;
		}
	}
		
	if (country[i][0] == K) {
		System.out.println(rank);
		break;
	}
}
```

## :black_nib: **Review**
정렬 오랜만..

## 📡**Link**
- https://www.acmicpc.net/problem/8979
