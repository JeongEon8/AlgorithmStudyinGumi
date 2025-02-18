# [백준 - G4] 32654. 게임 오브 데쓰 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 그래프 탐색
- 게임 이론

## ⏲️**Time Complexity**

$O(NK)$

## :round_pushpin: **Logic**
지목을 따라가면서 최종적으로 player 1이 마지막에 지목되지 않는 경우를 찾는다.  
반복되는 계산이 많으므로 만약 답이 아닌경우 results를 기록해 step 수를 늘리더라도 중복계산하지 않게 해결해준다.
첫 player 1의 턴에 첫 지목 이후 모든 경우가 player 1이 지지 않는 경우가 있다면 그 경우를 찾아서 답으로 출력하면 된다.

```java
static boolean Game(int step,int player){
	if(step == 0){
		if(player==1)return false;
		else return true;
	}
	boolean result  = true;
	if(results[step][player]==0) {
		result &= Game(step - 1, players[player][0]);
		if (players[player][1] != players[player][0]) {
			result &= Game(step - 1, players[player][1]);
		}
		if(result)results[step][player]=1;
		else results[step][player]=2;
	}else if(results[step][player]==1){
		result = true;
	}else{
		result = false;
	}
	return result;

}
```

## :black_nib: **Review**
게임이론은 항상 더 쉽게 풀 방법이 있을거 같은데 아직은 잘 모르겠다..

## 📡**Link**

https://www.acmicpc.net/problem/32654
