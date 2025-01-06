# [백준 - g3] 20303. 할로윈의 양아치

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 자료 구조
- 그래프 이론
- 그래프 탐색
- 분리 집합
- 배낭 문제

## :round_pushpin: **Logic**

jointset으로 친구들 그룹끼리 묶고 해당 그룹끼리의 인원수 합, 사탕합을 기록한다.  
이를 냅색으로 울음소리가 공명하는 아이수 미만중에 최대 사탕 개수를 구하면 된다.

```java
  	Map<Integer,Group> groupMap = new HashMap<>();
		List<Integer> kList = new ArrayList<>();
		kList.add(0);
		for(int i = 1; i<=n;i++) {
			int parent = findParent(i);
			int candy = kArr[i].candy;
			int population = 1;
			if(groupMap.containsKey(parent)) {
				Group group = groupMap.get(parent);
				candy += group.candy;
				population += group.population;
			}else {
				kList.add(parent);
			}
			groupMap.put(parent, new Group(candy,population));
		}
		int[][] dp = new int[kList.size()][k];
		for(int i = 1; i<kList.size();i++) {
			Group g = groupMap.get(kList.get(i));
			for(int j = 1;j<k;j++) {
				if(g.population<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-g.population]+g.candy);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

```

## :black_nib: **Review**

SSAFY에서 배운 알고리즘을 총 집합한 문제다.  
사탕을 왜 뺏어갈까..

그러게요...
사탕 맛있겠당 냠냠

## 📡**Link**

https://www.acmicpc.net/problem/20303
