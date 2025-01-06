# [백준 - G5] 1107.리모컨 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
O(NM)

## :round_pushpin: **Logic**
1. for문으로 0부터 999999만큼 돌아준다
   	- 최대 채널입력이 500000이라서 입력수만큼 9를 대입하면 999999가 된다.
2. 고장난 수가 있으면 continue 해준다.
   	- String으로 바꾸고 .contains를 사용하여 고장난 수가 포함된느지 확인
3. Math.abs() 를 사용하여 차이를 구하고 최솟값을 갱신해준다.

4. 그리고 기본 채널값이 100번이므로 100에서 차이를 구해서 최솟값이랑 비교하여 갱신해준다.
5. 최솟값 출력
```java
	for(int i = 0; i<=999999;i++) {
        	boolean check = false;
        	for(int n:num) {
        		if((i+"").contains(n+"")) {
        			check= true;
        			break;	
        		}
        	}
        	if(check) {
        		continue;
        	}
        	int total = Math.abs(N-i)+(i+"").length();
        	
        	if(min>total) {
        		min = total;
        	}
        	
        	
        }
        if(Math.abs(N-100)<min) {
        	min=Math.abs(N-100);
        }
        System.out.println(min);
```



## :black_nib: **Review**
- 처음에는 bfs로 채널 누르는거 다 탐색 했지만 메모리 초과가 뜨더라구요
- 제가 푼거 보다 더 좋은 방식이 있을까요?

## 📡**Link**
- https://www.acmicpc.net/problem/1107
