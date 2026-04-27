# [백준 - G5] 12852. 1로 만들기 2 

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 주어진 숫자를 -1, 나누기2, 3 을 해서 최소한으로 횟수로 1을 만드는 문제
- 1부터 N까지 순차적으로 찾으면 되것이라 판단
  - 배열 2개를 만들어서 하나는 최소 개수를 담고 하나는 이전 값을 담는 배열
    1. 크기가 N+1 인 배열 2개 생성
	
    2. 1부터 3까지 직접 넣어준다. 
		- 1일경우 :  횟수 0이고 이전값 1
    	- 2일경우 : 횟수 1이고 이전값 1
     	- 3일경우 : 횟수 1이고 이전값 1
    3. 그 다음 숫자 부터 -1값의 횟수와 나누기2, 나누기 3 각각의 횟수를 비교 해서 최솟값을 선정
    4. 선정한다음 횟수는 +1 시키고 이전값에도 추가해준다.
       - 4 일 경우 : -1 값은 3 이고 횟수는 1이고, 나누기 2를 하면 2이고 횟수는 1, 나누기 3은 안됨
	   				최소 횟수인 -1, /2 중에 하나 고르고 값을 반영 arr[4] =  1+1 =2, save[4] = 3 또는 2
	```java
	for(int i = 0; i<=N; i++) {
			if(i ==0) {
				arr[i] = 0;
			}else if(i==1) {
				arr[i] = 0;
				save[i] = 1;
			}else if(i==2) {
				arr[i] = 1;
				save[i]=1;
			}else if(i==3) {
				arr[i] = 1;
				save[i] =1;
			}else {
				int min = arr[i-1];
				int index = i-1;
		
				if(i % 2 ==0 && min > arr[i/2] ) {
					min = arr[i/2];
					index = i/2;
				}
				
				if(i % 3 == 0 && min > arr[i/3] ) {
					min = arr[i/3];
					index = i/3;
				}
				
				arr[i]=min+1;
				save[i]= index;
			}
		}
```


	5. N까지 반복하고 횟수는 arr[N]으로 출력 하고 숫자는 save를 1이 나올때 까지 탐색해준다.
	```java
	System.out.println(arr[N]);
		int n = N;
		System.out.print(n);
		while(n!=1) {
			n = save[n];
			System.out.print(" "+n);
		}
```



## :black_nib: **Review**
- 황금연휴 시작을 알고리즘

## 📡**Link**
[https://www.acmicpc.net/problem/12852](https://www.acmicpc.net/problem/12852)
