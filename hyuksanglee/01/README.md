# [백준 - S5] 29812. 아니 이게 왜 안 돼

## ⏰ **time**

45분

## :pushpin: **Algorithm**
- 이분탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 배열에 넣고 3숫자를 1번째 숫자: 한번씩 돌고, 2번째 숫자: 1번째 숫자로 1을 더해서 시작하고, 3번째는 마지막 숫자로 설정하고
- 세개를 더했을때 크면 3번째꺼를 줄이고 작으면 2번째꺼를 늘려준다.
- 세개 더했을때 최솟값을 출력해준다.
```java
   for(int i = 0; i<N; i++) {
			int j = i+1;
			int k = N-1;
			while(j<k) {
				if(max>  Math.abs(arr[i]+arr[j]+arr[k])) {
					max = Math.abs(arr[i]+arr[j]+arr[k]);
					result[0] = arr[i];
					result[1] = arr[j];
					result[2] = arr[k];
					if(max ==0) {
						for(int z =0; z<3; z++) {
							System.out.print(result[z]);
							System.out.print(" ");
						}
						return;
						
					}
				}
				if(arr[i]+arr[j]+arr[k]>0) {
					k--;
				}else if(arr[i]+arr[j]+arr[k]<0) {
					j++;
				}
			}
		}
```

## :black_nib: **Review**  
- 골3 치곤 쉬웠음

## 📡**Link**
https://www.acmicpc.net/problem/2473
