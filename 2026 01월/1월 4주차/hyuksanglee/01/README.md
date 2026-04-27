# [백준 - G5] . 치킨 배달

## ⏰ **time**

60분

## ⏲️**Time Complexity**

$O(집*M* 치킨)$

## :round_pushpin: **Logic**

1. 리스트로 치킨의 좌표와 집 좌표를 담아준다.
```java
for(int i = 0; i<N; i++) {
			input = in.readLine().split(" ");
			for(int j = 0; j<N; j++) {
				int num = Integer.parseInt(input[j]);
				
				if(num ==1) {
					Info ih = new Info(i,j);
					home.add(ih);
				}
				else if(num ==2 ) {
					Info ic = new Info(i,j);
					chicken.add(ic);
					sizeC++;
				}
			}
		}
```
2. 치킨집에서 집까지 각각의 거리를 미리 계산해서 배열에 담아준다.

```java
 for(int i = 0; i<chicken.size(); i++) {
	        	
			 int c = chicken.get(i).i;
			 int r = chicken.get(i).j;
			 for(int j = 0 ; j<home.size(); j++) {
				 
				 di[i][j] = Math.abs(c-home.get(j).i) + Math.abs(r-home.get(j).j);
				 
			 }
        }
```
		
		
3. 조합으로 치킨집이 가능한 수만큼 수를 조합하고 해당 배열에 있는 조합의 거리중 최솟값을 더해준다.
```java
static void combination(int depth, int start) {
	   
	    if (depth == M) {
	    	int total =0;
	        for(int i = 0; i<home.size(); i++) {
	        	int min = Integer.MAX_VALUE;
	        	for(int j = 0; j<M; j++) {
	        		if(min > di[pick[j]][i]) {
	        			min = di[pick[j]][i];
	        		}
	        	}
	        	total+= min;
	        	
	        	
	        }
	        if(result > total) {
        		result = total;
        	}
	        return;
	    }
	    
	    for (int i = start; i < sizeC; i++) {
	        pick[depth] = i;
	        combination(depth + 1, i + 1);
	    }
	}
```
4. 총 더한 값이 최소가 되는값 출력

## :black_nib: Review

## 📡**Link**

- https://www.acmicpc.net/problem/15686
