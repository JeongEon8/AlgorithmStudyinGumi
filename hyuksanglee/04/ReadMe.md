# [백준 - S2] 2644. 촌수계산
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
- dfs

## :round_pushpin: **Logic**
1. 부모가 누구인지 저장하는 배열 생성하고 자기자신인 부모로 초기화시킴

2. 입력 받은 자식과 부모 값을 배열에 넣어준다.
    - 배열[자식] = 부모

3. dfs를 돌려서 해당값의 조상을 찾아서 리스트에 넣어준다.

4. 두 조상의 같은 조상이 있으면 멈추고 해당되는 index를 더해준다.
   
```#java
public static void dfs(int n, int y , ArrayList<Integer> p ) {
		if(arr[n] == y) {
			result = p.size()+1;
			return;
		}
		
		if(arr[n]== n) {
			return;
		}
		p.add(arr[n]);
		dfs(arr[n], y, p);
	}
```
## :black_nib: **Review**

- main을 mian으로 적어서 이클립스 작동을 안하길래 해결한다고 시간을 썻어요

## 📡**Link**

- https://www.acmicpc.net/problem/2644
  
