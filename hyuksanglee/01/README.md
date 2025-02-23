# [백준] 2960. 에라토스테네스의 체


## ⏰ **time**
20분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
O(N log N)

## :round_pushpin: **Logic**
- 2부터 N까지 모든 정수를 적는다.
- 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
- P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
- 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
```java
            while(K>0) {
				for(int i=2; i<N+1; i++) {
					if(arr[i]!=0) {
						continue;
					}
					for(int j =1; j*i<N+1; j++) {
						if(arr[j*i]==0) {
							K--;
							arr[j*i]=1;
							if(K==0) {
								System.out.print(j*i);
								break;
							}
						}
					}
				}
			}
```


## :black_nib: **Review**
문제에서 시키는데로 하니깐 바로 풀려요

## 📡**Link**
https://www.acmicpc.net/problem/2960
