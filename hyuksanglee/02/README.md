# [백준 - G5] 5557. 1학년

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 왼쪽 수부터 N-1 까지 더하거나 뺴서 N숫자 만들기 ( 대신 중간에 0미만이나 20 초과 뜨면 안됨)
  1. 계산 결과를 담는 2차원 배열 생성
     - 첫번째가 8 이고 두번째가 7이면 arr[1][8] =1 이고 arr[2][8+7] = 1, arr[2][8-7] =1
  2. 첫번째값은 해당 값에 1을 채워준다.
     - [8 3 2 4 8 7 2 4 0 8 8] 일경우 arr[1][8] = 1 을 채워준다.
  3. 두번째 부터 N-1 까지 이전 값에 횟수가 1이상이면 더하거나 뺴서 0이나 20안이면 이전 값의 횟수를 더해준다.
     - ex) 3번째 : n-1(2)이 5,11 이 횟수가 1씩있고 5+2 = 7, 5-2= 3, 11+2 = 13, 11-2 = 9 가 다 0~20 사이 이므로 arr[3][7], arr[3][3], arr[3][13], arr[3][9] 에 arr[2][5], arr[2][11] 의 값인 1씩 더해준다. 
	```java
	for(int n = 0; n < N-1; n++) {
			int num = Integer.parseInt(input[n]);
			if(n==0) {
				arr[n+1][num] =1;
			}else {
				for(int i = 0; i<21; i++) {
					long nu = arr[n][i];
					if(nu >= 1) {
						int total = i + num;
						if(total <=20) {
							arr[n+1][total] += arr[n][i];
						}
						total = i - num;
						
						if(total>=0) {
							arr[n+1][total] += arr[n][i];
						}
					}
				}
			}
			
			
		}
```




## :black_nib: **Review**
- 알고리즘 풀 때 크기를 잘보고 코드를 짜야할거 같아요 처음에 int로 했다가 틀렸어요

## 📡**Link**
[https://www.acmicpc.net/problem/5557](https://www.acmicpc.net/problem/5557)
