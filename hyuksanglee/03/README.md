# [백준 - 골드 3] 9466. 텀 프로젝트
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 배열에 해당 번호에 학생이 원하는 학생의 번호를 입력한다

2. dfs 탐색으로 프로젝트 팀 구성을 확인한다.

    1. 원하는 학생이 방문을 했는지 확인하고 안했으면 원하는 학생을 탐색
    2. 만약에 방문을 했던 학생이면 지금까지 탐색을 했던 학생중에 팀을 이룰수 있는지 확인하고 팀을 구성하고 나머지 학생 몇명인지 확인하고 결과를 저장하는 변수에 합해준다
    
3. 마지막으로 결과를 저장했던 변수 출력
```java
public static void dfs(int n, ArrayList<Integer> list) {

		isSelcetd[n] = true;
		
		if (isSelcetd[arr[n]] == false) {
			list.add(n);
			dfs(arr[n], list);
		}else {
			if (n == arr[n]) {
				isSelcetd[arr[n]] = true;
				result += list.size();
				return;
			}
			int index = 0;
			for (int i : list) {
				if (arr[n] == i) {
					result += index;
					return;
				}
				index++;
			}
			result += list.size()+1;
			
			return;
		}
		

	}
```

## :black_nib: **Review**
- 처음에는 방문처리를 dfs 마지막 줄에 했었는데 시간초과가 떠서 제일 위로 올리니깐 해결 되었어요

## 📡 Link
https://www.acmicpc.net/problem/9466
